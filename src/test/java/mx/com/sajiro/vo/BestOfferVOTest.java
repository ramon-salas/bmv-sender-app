/**
 * SAJIRO 15 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author SAJIRO
 */
class BestOfferVOTest {

    @Test
    void test() {
        final var bestOfferVO = new BestOfferVO();
        bestOfferVO.setType('B');
        bestOfferVO.setInstrumentId(1);
        bestOfferVO.setVolume(1);
        bestOfferVO.setPrice(1);
        bestOfferVO.setSide('a');
        bestOfferVO.setOperationType('a');

        assertEquals("B|1|1|1|a|a", bestOfferVO.toString());
    }

}
