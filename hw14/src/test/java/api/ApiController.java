package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.JSONMapperImpl;
import utils.PropertyReader;

import java.io.Serializable;

public abstract class ApiController<T extends Serializable> {
    final RequestSpecification requestSpecification;
    final JSONMapperImpl<T> mapper;
    final PropertyReader properties;

    public ApiController() {
        properties = new PropertyReader();
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(properties.getValue("baseURL"));
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
        this.mapper = new JSONMapperImpl<>();
    }
}
