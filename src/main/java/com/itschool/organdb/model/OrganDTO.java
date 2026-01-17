package com.itschool.organdb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrganDTO(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long entryId,
                       String manufacturer,
                       String geoLocation,
                       Integer manufYear) {



}
