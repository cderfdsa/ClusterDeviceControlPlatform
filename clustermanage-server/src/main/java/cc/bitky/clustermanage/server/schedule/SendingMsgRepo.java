package cc.bitky.clustermanage.server.schedule;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

import cc.bitky.clustermanage.server.message.send.SendableMsg;
import io.netty.channel.ChannelPipeline;
import io.netty.util.HashedWheelTimer;

@Repository
public class SendingMsgRepo {
    private final List<ChannelPipeline>  channelPipelines = new ArrayList<>();
    private final ConcurrentHashMap<MsgKey, byte[]> MsgHashMap = new ConcurrentHashMap<>(65536);
    private final HashedWheelTimer hashedWheelTimer = new HashedWheelTimer();
    private final LinkedBlockingDeque<SendableMsg> linkedBlockingDeque = new LinkedBlockingDeque<>(655360);

    public List<ChannelPipeline> getChannelPipelines() {
        return channelPipelines;
    }

    public ConcurrentHashMap<MsgKey, byte[]> getMsgHashMap() {
        return MsgHashMap;
    }

    public HashedWheelTimer getHashedWheelTimer() {
        return hashedWheelTimer;
    }

    public LinkedBlockingDeque<SendableMsg> getLinkedBlockingDeque() {
        return linkedBlockingDeque;
    }
}
