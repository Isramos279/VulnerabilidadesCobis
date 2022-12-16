package com.cobis.cloud.atm.aws.batch.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataBaseCredentials {
    String username;
    String password;
    String engine;
    String database;
    String arguments;
    String masterEndpoint;
    String masterPort;
    String readReplicaEndpoint;
    String readReplicaPort;
}