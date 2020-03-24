package com.avinash.sample;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyStore;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reputation.profile.publish.bing.BingLocalConfig.AgencyConfig;
import com.reputation.profile.publish.bing.model.Business;
import com.reputation.profile.publish.bing.model.BusinessError;
import com.reputation.profile.publish.bing.model.BusinessResponse;
import com.reputation.profile.publish.bing.model.BusinessStatus;
import com.reputation.profile.publish.bing.model.CreateBusinessesRequest;
import com.reputation.profile.publish.bing.model.CreateBusinessesResponse;
import com.reputation.profile.publish.bing.model.CriteriaType;
import com.reputation.profile.publish.bing.model.DeleteBusinessesRequest;
import com.reputation.profile.publish.bing.model.DeleteBusinessesResponse;
import com.reputation.profile.publish.bing.model.GetBusinessStatusInfoRequest;
import com.reputation.profile.publish.bing.model.GetBusinessStatusInfoResponse;
import com.reputation.profile.publish.bing.model.GetBusinessesRequest;
import com.reputation.profile.publish.bing.model.GetBusinessesResponse;
import com.reputation.profile.publish.bing.model.Identity;
import com.reputation.profile.publish.bing.model.Response;
import com.reputation.profile.publish.bing.model.SearchCriteria;
import com.reputation.profile.publish.bing.model.UpdateBusinessesResponse;
import com.reputation.profile.publish.bing.model.WarningMessage;
import com.reputation.profile.publish.exceptions.InvalidDataException;
import com.reputation.profile.publish.exceptions.TargetException;
import com.reputation.profile.publish.model.Context;
import com.reputation.profile.publish.model.ExportDataWrapper;
import com.reputation.profile.publish.model.PublishContext;
import com.reputation.profile.publish.model.PublishError;
import com.reputation.profile.publish.model.PublishResponse;
import com.reputation.profile.publish.model.PublishState;
import com.reputation.profile.publish.model.RollbackTarget;
import com.reputation.profile.publish.model.SourceConfigurations;
import com.reputation.profile.publish.model.Throttle;
import com.reputation.secrets.client.SecretsProvider;
import com.reputation.thrift.r4e.acommon.R4EACommonConstants;


public class Driver implements FirstInterface{

	public static void main(String[] args) {
		

        RestTemplate restTemplate = null;
        try {
            byte[] certificate = secretsProvider.getAsBase64Bytes(agencyId, "bing.certificate");
            String password = secretsProvider.getAsString(agencyId, "bing.password");
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new ByteArrayInputStream(certificate), password.toCharArray());

            SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
            sslContextBuilder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLContext context = sslContextBuilder.loadKeyMaterial(keyStore, password.toCharArray()).build();
            HttpClientBuilder builder = HttpClientBuilder.create();
            SSLConnectionSocketFactory sslConnectionFactory = new SSLConnectionSocketFactory(context);
            builder.setSSLSocketFactory(sslConnectionFactory);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("https", sslConnectionFactory).build();
            HttpClientConnectionManager ccm = new PoolingHttpClientConnectionManager(registry);
            builder.setConnectionManager(ccm);
            HttpClient httpClient = builder.build();

            ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
            restTemplate = new RestTemplate(requestFactory);
        } catch (Exception e) {
            throw new TargetException(PublishError.INVALID_CREDENTIAL, "Failed to load bing certificates", e, false);
        }
        return restTemplate;
    

	}

}
