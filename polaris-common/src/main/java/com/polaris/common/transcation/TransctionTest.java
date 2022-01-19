package com.polaris.common.transcation;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class TransctionTest {
    public static void main(String[] args) {
        System.out.println("1");
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                super.afterCommit();
            }
        });
    }
}
