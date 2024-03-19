/**
 * SAJIRO 18 mar. 2024
 * This software is the property of SAJIRO and is protected by copyright laws.
 * Unauthorized reproduction, distribution, or modification of this code is
 * strictly prohibited without the express permission of SAJIRO.
 */
package mx.com.sajiro.service;

import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mx.com.sajiro.bmv.BestOfferEncoder;
import mx.com.sajiro.bmv.CapitalTradesEncoder;
import mx.com.sajiro.bmv.EventsSystemEncoder;
import mx.com.sajiro.bmv.MutualFundTradesEncoder;
import mx.com.sajiro.bmv.ProbableAllocationPriceEncoder;
import mx.com.sajiro.bmv.RegistryOperationsEncoder;
import mx.com.sajiro.bmv.StatusChangesEncoder;
import mx.com.sajiro.bmv.ToMiddlePriceExistingQuotesEncoder;
import mx.com.sajiro.bmv.TradabilityEncoder;
import mx.com.sajiro.bmv.VirtualTradesEncoder;
import mx.com.sajiro.bmv.WeightedAveragePriceSettlementPricesEncoder;
import mx.com.sajiro.constant.MessageTypeEnum;
import mx.com.sajiro.exception.BusinessException;
import mx.com.sajiro.exception.EncoderException;
import mx.com.sajiro.exception.MessageConversionException;
import mx.com.sajiro.util.MessageByteConverterUtil;
import mx.com.sajiro.vo.BestOfferVO;
import mx.com.sajiro.vo.CapitalTradeVO;
import mx.com.sajiro.vo.MiddlePriceExistingQuotesVO;
import mx.com.sajiro.vo.MutualFundTradeVO;
import mx.com.sajiro.vo.ProbableAllocationPriceVO;
import mx.com.sajiro.vo.RegistryOperationsVO;
import mx.com.sajiro.vo.StatusChangesVO;
import mx.com.sajiro.vo.SystemEventVO;
import mx.com.sajiro.vo.TradabilityVO;
import mx.com.sajiro.vo.VirtualTradeVO;
import mx.com.sajiro.vo.WeightedAveragePriceVO;

/**
 * @author SAJIRO
 */
@Service
public class BytesConverterServiceImpl implements BytesConverterService {

    /*
     * (non-Javadoc)
     * @see
     * mx.com.sajiro.service.BytesConverterService#convert(java.lang.String,
     * com.google.gson.JsonObject).
     */
    @Override
    public byte[] convert(final String type, final JsonObject locObj)
            throws BusinessException {
        try {
            return convert(locObj, switch (MessageTypeEnum.find(type)) {
            case STATUS_CHANGES_TYPE -> new MessageProperties(
                    StatusChangesVO.class, StatusChangesEncoder.BLOCK_LENGTH);
            case WEIGHTED_AVERAGE_PRICE_TYPE -> new MessageProperties(
                    WeightedAveragePriceVO.class,
                    WeightedAveragePriceSettlementPricesEncoder.BLOCK_LENGTH);
            case CAPITAL_TRADES_TYPE -> new MessageProperties(
                    CapitalTradeVO.class, CapitalTradesEncoder.BLOCK_LENGTH);
            case REGISTRY_OPERATIONS_TYPE -> new MessageProperties(
                    RegistryOperationsVO.class,
                    RegistryOperationsEncoder.BLOCK_LENGTH);
            case SYSTEM_EVENT_TYPE -> new MessageProperties(SystemEventVO.class,
                    EventsSystemEncoder.BLOCK_LENGTH);
            case PROBABLE_ALLOCATION_PRICE -> new MessageProperties(
                    ProbableAllocationPriceVO.class,
                    ProbableAllocationPriceEncoder.BLOCK_LENGTH);
            case MIDDLE_PRICE_EXISTING_QUOTES -> new MessageProperties(
                    MiddlePriceExistingQuotesVO.class,
                    ToMiddlePriceExistingQuotesEncoder.BLOCK_LENGTH);
            case TRADABILITY -> new MessageProperties(TradabilityVO.class,
                    TradabilityEncoder.BLOCK_LENGTH);
            case BEST_OFFER -> new MessageProperties(BestOfferVO.class,
                    BestOfferEncoder.BLOCK_LENGTH);
            case VIRTUAL_TRADE -> new MessageProperties(VirtualTradeVO.class,
                    VirtualTradesEncoder.BLOCK_LENGTH);
            case MUTUAL_FUNDS_TRADES -> new MessageProperties(
                    MutualFundTradeVO.class,
                    MutualFundTradesEncoder.BLOCK_LENGTH);
            });
        } catch (Exception e) {
            throw new MessageConversionException(e);
        }
    }

    private byte[] convert(final JsonObject locObj,
            final MessageProperties messageProperties) throws EncoderException {
        return MessageByteConverterUtil.convertToBytes(locObj,
                messageProperties.getClazz(),
                messageProperties.getMessageLength());
    }

    @AllArgsConstructor
    @Getter
    class MessageProperties {
        private final Class<?> clazz;
        private final int messageLength;
    }

}
