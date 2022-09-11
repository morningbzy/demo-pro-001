package com.example.demoproems.device;

import lombok.extern.slf4j.Slf4j;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class Sniffer {

    @Scheduled(cron = "*/2 * * * * ?")
    public void sniff() {
        for(int i = 2; i < 250; i++) {
            log.info("Sniffing... udp:10.14.56." + i + "/161");
            CommunityTarget<Address> target = new CommunityTarget<>();

            Address address = GenericAddress.parse("udp:10.14.56." + i + "/161");

            target.setAddress(address);
            target.setCommunity(new OctetString("public"));
            target.setRetries(2);
            target.setTimeout(5 * 60);
            target.setVersion(SnmpConstants.version2c);

            TransportMapping<UdpAddress> transport = null;
            try {
                transport = new DefaultUdpTransportMapping();
                transport.listen();

                Snmp protocol = new Snmp(transport);
                PDU request = new PDU();
                request.add(new VariableBinding(new OID(".1.3.6.1.2.1.1.1")));
                request.setType(PDU.GETNEXT);
                ResponseEvent<Address> responseEvent = protocol.send(request, target);

                PDU response = responseEvent.getResponse();

                if (Objects.nonNull(response)) {
                    log.info("request.size()=" + request.size());
                    log.info("response.size()=" + response.size());
                    response.getAll().forEach(vb -> log.info(vb.toString()));

                } else {
                    log.info("request.size()=" + request.size());
                    log.info("response is null");
                }
                transport.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
