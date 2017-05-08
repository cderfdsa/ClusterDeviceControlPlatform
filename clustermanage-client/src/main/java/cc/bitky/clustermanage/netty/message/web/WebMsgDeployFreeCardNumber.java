package cc.bitky.clustermanage.netty.message.web;

import cc.bitky.clustermanage.netty.message.MsgType;
import cc.bitky.clustermanage.netty.message.base.BaseMessage;

/**
 * 服务器部署万能卡号
 */
public class WebMsgDeployFreeCardNumber extends BaseMessage {

    private long[] cardNumbers = new long[16];

    /**
     * 服务器部署万能卡号
     *
     * @param groupId 组号
     * @param boxId   设备号
     * @param numbers 万能卡号集合
     */
    public WebMsgDeployFreeCardNumber(int groupId, int boxId, long[] numbers) {
        super(groupId, boxId);
        setMsgId(MsgType.SERVER_SET_FREE_CARD_NUMBER);
        if (numbers.length == 16) {
            this.cardNumbers = numbers;
            return;
        }
        int length = numbers.length >= 16 ? 16 : numbers.length;
        System.arraycopy(numbers, 0, cardNumbers, 0, length);
    }

    public long[] getCardNumbers() {
        return cardNumbers;
    }
}