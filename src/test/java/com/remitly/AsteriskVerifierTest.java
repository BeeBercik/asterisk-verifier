package com.remitly;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsteriskVerifierTest {
    static String testPath;

    @BeforeAll
    static void setTestPath() {
        testPath = "src/test/java/com/remitly/";
    }

    @Test
    void shouldThrowAwsDocumentFileExceptionBecauseOfFileProblem() {
        assertThrows(AwsDocumentFileException.class, () -> {
            new AsteriskVerifier().checkAsterisk("src/test/java/com/remitly/incorrectAwsDocument.json");
        });
    }

    @Test
    void shouldThrowAwsDocumentFileExceptionBecauseOfBadPath() {
        assertThrows(AwsDocumentFileException.class, () -> {
            new AsteriskVerifier().checkAsterisk(testPath + "BAD-VALUE");
        });
    }

    @Test
    void shouldReturnFalseWithAsterisk() {
       try {
           assertDoesNotThrow(() -> // in case when path is incorrest and exception is thrown test will fail
               assertFalse(new AsteriskVerifier().checkAsterisk(testPath + "withAsterisk.json"))
           );
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

    @Test
    void shouldReturnTrueWithEmptyString() {
        try {
            assertDoesNotThrow(() ->
                assertTrue(new AsteriskVerifier().checkAsterisk(testPath + "withEmptyString.json"))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void shouldReturnTrueWithObject() {
        try {
            assertDoesNotThrow(() ->
                assertTrue(new AsteriskVerifier().checkAsterisk(testPath + "withJsonObject.json"))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void shouldReturnTrueWithJsonArray() {
        try {
            assertDoesNotThrow(() ->
                assertTrue(new AsteriskVerifier().checkAsterisk(testPath + "withJsonArray.json"))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void shouldReturnTrueWithBoolean() {
        try {
            assertDoesNotThrow(() ->
                assertTrue(new AsteriskVerifier().checkAsterisk(testPath + "withBoolean.json"))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void shouldReturnTrueWithNull() {
        try {
            assertDoesNotThrow(() ->
                    assertTrue(new AsteriskVerifier().checkAsterisk(testPath + "withNull.json")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}