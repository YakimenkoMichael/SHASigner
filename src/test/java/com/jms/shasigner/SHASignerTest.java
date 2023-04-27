package com.jms.shasigner;

import java.security.PrivateKey;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Yakimenko Michael
 */
class SHASignerTest {
    private static final String PARTNER = "AA";

    @Test
    void test_sign1() throws Exception {
        PrivateKey key = SHASigner.getPrivateKey(PARTNER);

        String source = concatenate("pay", "payReference", "100USD");

        byte[] sign = SHASigner.sign(key, source.getBytes());
        String hexSign = new String(Hex.encodeHex(sign));
        assertEquals("0FA682917F5B1F2D499D266C4BEE5C25ADAFCA3951178DE3D53088F54C78B01844D02949BD129" +
                        "7E6599C7C539E4FDC692D387FFE1EFC1A1278FA0EBE040E18ECC45CE03F3D537DC154D35D60C38F277ED8909A45" +
                        "86345A4F770FD535B86BF508B4BAF0788DEFEFD20D64C4E797988A991EB23B583D0135DF1F3BC9837B4CB40708E" +
                        "629AC54253203747D61E5E05BDF95927140B5419408710D5114D74ECDD14988D55C0379290AFC542CA9ED31454E" +
                        "D75CEC7C414737DE91F12E8FEAB4AD6521B1FD76789913D197BF5147067B664A67333FE3FC7A0814EE59D13AF66" +
                        "DA857FD7B81862DF374115DC6931D79C4796324CEE4A8FE6D3A40A29D6C5CA37C252BE4",
                hexSign);
    }

    @Test
    void test_sign512() throws Exception {
        PrivateKey key = SHASigner.getPrivateKey(PARTNER);

        String source = concatenate("pay", "payReference", "100USD");

        byte[] sign = SHASigner.sign512(key, source.getBytes());
        String hexSign = new String(Hex.encodeHex(sign));
        assertEquals("920F8D21291D25313D50F479D42902B0B6D003B7BE9627F990A6803F613595025651C871EE22482CBD161" +
                        "9FFDD1674896242A09F289933CAD719AFA91BA6015102D0AE90BB386F2DABF3CF9A645D13D2C9EE54B219D07995" +
                        "50B3651FA034C263460A670D11D2CBF1550BF65F43132926200F0E555B6B02C5CE0A8B51E5E1D1A3A2BF07169AE" +
                        "DACEF7CEC7413CE744459D07229E871B3849D0FC689E37E15552233CCC9D9487E836733CD8D4B50D572E0F6F55C" +
                        "689C2AB72C5014154BE3266DFEDE39883B83670A96703EE6DF2AB9C8A433AD65F37B55D2025141D280295A44D8B" +
                        "67E13AEF777FD2F8C3C37EDAC23248C94634F52001218C735E555ADDA661385",
                hexSign);
    }

    private String concatenate(String... strings) {
        StringBuilder result = new StringBuilder();
        for (String arg : strings) {
            result.append(arg);
        }
        return result.toString();
    }
}