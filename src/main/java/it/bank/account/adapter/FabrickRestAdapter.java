package it.bank.account.adapter;

import it.bank.account.domain.port.FabrickPort;
import it.bank.account.domain.port.exceptions.FabrickException;
import it.bank.account.dto.domain.Balance;
import it.bank.account.dto.domain.moneytransfer.MoneyTransferRequest;
import it.bank.account.dto.domain.moneytransfer.MoneyTransferResponse;
import it.bank.account.dto.domain.TransactionList;
import it.bank.account.dto.fabrick.FabrickResponseBalance;
import it.bank.account.dto.fabrick.FabrickResponseTransactionList;
import it.bank.account.dto.fabrick.FabrickResponse;
import it.bank.account.dto.fabrick.FabrickResponseMoneyTransferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.logging.Logger;

@Component
@Primary
public class FabrickRestAdapter implements FabrickPort {

    private static final Logger LOGGER = Logger.getLogger(FabrickRestAdapter.class.getName());
    private static final String BASE_URL = "https://sandbox.platfr.io";
    private static final String AUTH_SCHEMA = "S2S";
    private static final String API_KEY = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
    private static final Long ACCOUNT_ID = 14537780L;
    private static String CONTENT_TYPE = "application/json";

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public FabrickResponse<Balance> getBalance(long accountId) throws FabrickException {
        LOGGER.info("Fabrick - getBalance");
        String url = BASE_URL + "/api/gbs/banking/v4.0/accounts/" + ACCOUNT_ID + "/balance";
        HttpEntity<String> entity = new HttpEntity<String>(getHttpHeaders());
        ResponseEntity<FabrickResponseBalance> response = restTemplate.exchange(url, HttpMethod.GET, entity, FabrickResponseBalance.class);

        FabrickResponse<Balance> result=response.getBody();
        if(response.getStatusCode().is2xxSuccessful()){
            result = response.getBody();
        }else{
            throw new FabrickException("Error during the Fabrick service call (" + response.getStatusCode() + ")");
        }
        return result;
    }
    @Override
    public FabrickResponse<TransactionList> getTransactions(long accountId, LocalDate fromDate, LocalDate toDate) throws FabrickException {
        LOGGER.info("Fabrick - getTransaction");
        String url = BASE_URL + "/api/gbs/banking/v4.0/accounts/" + accountId + "/transactions?fromAccountingDate=" + fromDate + "&toAccountingDate=" + toDate;
        HttpEntity<String> entity = new HttpEntity<String>(getHttpHeaders());
        try {
            ResponseEntity<FabrickResponseTransactionList> response = restTemplate.exchange(url, HttpMethod.GET, entity, FabrickResponseTransactionList.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new FabrickException("Error during the Fabrick service call (" + response.getStatusCode() + ")");
            }
        } catch (RestClientException e) {
            LOGGER.severe("Fabrick - ERROR: " + e.getMessage());
            throw new FabrickException("Fabrick Exception: " + e.getMessage());
        }
    }

    @Override
    public FabrickResponse<MoneyTransferResponse> createMoneyTransfer(Long accountId, MoneyTransferRequest moneyTransferRequest) throws FabrickException {
        LOGGER.info("Fabrick - createMoneyTransfer");
        String url = BASE_URL + "/api/gbs/banking/v4.0/accounts/" + accountId + "/payments/money-transfers";
        HttpHeaders headers = getHttpHeaders();
        headers.set("X-Time-Zone","Europe/Rome");
        HttpEntity<MoneyTransferRequest> entity = new HttpEntity<MoneyTransferRequest>(moneyTransferRequest,headers);
        try {
            ResponseEntity responseObject = restTemplate.exchange(url, HttpMethod.POST, entity,Object.class);
            ResponseEntity<FabrickResponseMoneyTransferResponse> response = (ResponseEntity<FabrickResponseMoneyTransferResponse>) responseObject;
            return response.getBody();
        }catch (RestClientException e){
            LOGGER.severe("Fabrick - ERROR: " + e.getMessage());
            throw new FabrickException("Fabrick Exception: " + e.getMessage());
        }
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Auth-Schema", AUTH_SCHEMA);
        headers.set("Api-Key", API_KEY);
        headers.set("Content-Type", CONTENT_TYPE);
        return headers;
    }
}
