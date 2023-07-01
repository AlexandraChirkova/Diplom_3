package client;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Auth;
import models.User;
import org.apache.http.HttpStatus;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UsersApiClient {
    public static final String API_URL = "https://stellarburgers.nomoreparties.site/api/";

    private final ArrayList<String> usersTokensForDelete = new ArrayList<>();

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(API_URL)
                .build();
    }

    @Step("Reg new user.")
    public Response register(User user) {
        return given()
                .spec(getRequestSpecification())
                .body(user.toJson())
                .when()
                .post(API_URL + "auth/register");
    }

    @Step("Auth user.")
    public void login(User user) {
        Auth authorizationInfo = given()
                .spec(getRequestSpecification())
                .body(user.toJson())
                .when()
                .post(API_URL + "auth/login")
                .as(Auth.class);

        usersTokensForDelete.add(authorizationInfo.getAccessToken());
    }

    @Step("Remove all created users.")
    public void deleteCreatedUsers() {
        usersTokensForDelete.forEach(this::delete);
    }

    @Step("Remove user.")
    public void delete(String token) {
        given()
                .spec(getRequestSpecification())
                .auth().oauth2(token)
                .when()
                .delete("auth/user")
                .then()
                .statusCode(HttpStatus.SC_ACCEPTED);
    }
}
