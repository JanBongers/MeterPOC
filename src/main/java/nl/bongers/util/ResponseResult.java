package nl.bongers.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ResponseResult {

    public static final ResponseEntity<String> AUTH_RESULT = new ResponseEntity<>("{\"guid\": \"8A19B879-E6AB-4316-9661-2039BE46F601\"}", HttpStatus.OK);

    public static final ResponseEntity<String> METER_OVERZICHT = new ResponseEntity<>("" +
            "{\n" +
            "   \"magazijncode\":\"CODE_MAG\",\n" +
            "   \"data\":[\n" +
            "      {\n" +
            "         \"meternummer\":\"E0044007211174718\",\n" +
            "         \"meterType\":\"Elektra\",\n" +
            "         \"leeftijd\":12,\n" +
            "         \"keyMonteur\":2\n" +
            "      },\n" +
            "      {\n" +
            "         \"meternummer\":\"E0044007211174818\",\n" +
            "         \"meterType\":\"Elektra\",\n" +
            "         \"leeftijd\":12,\n" +
            "         \"keyMonteur\":2\n" +
            "      },\n" +
            "      {\n" +
            "         \"meternummer\":\"E0044007211174918\",\n" +
            "         \"meterType\":\"Elektra\",\n" +
            "         \"leeftijd\":12,\n" +
            "         \"keyMonteur\":2\n" +
            "      },\n" +
            "      {\n" +
            "         \"meternummer\":\"G0044007211174718\",\n" +
            "         \"meterType\":\"Gas\",\n" +
            "         \"leeftijd\":8,\n" +
            "         \"keyMonteur\":4\n" +
            "      },\n" +
            "      {\n" +
            "         \"meternummer\":\"G0044007211174818\",\n" +
            "         \"meterType\":\"Gas\",\n" +
            "         \"leeftijd\":8,\n" +
            "         \"keyMonteur\":4\n" +
            "      }\n" +
            "   ]\n" +
            "}", HttpStatus.OK);
}
