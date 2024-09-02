package com.daviros.thriftpractice.client;

import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.daviros.thriftpractice.service.impl.ContactResource;
import com.daviros.thriftpractice.service.impl.ContactService;

public class ContactServiceClient {

	private final static Logger logger = LoggerFactory.getLogger(ContactServiceClient.class);

    public boolean ping() {
        try (TTransport transport = new TSocket("localhost", 9090)) {
        	logger.info("Contacting server...");
        	transport.open();
        	TProtocol protocol = new TBinaryProtocol(transport);
            ContactService.Client client = new ContactService.Client(protocol);
            return client.ping();
        } catch (Exception e) {
            logger.error("Server connection error: " + e.getMessage());
        }

        return false;
    }

    public boolean saveContact(ContactResource contact) {
        try (TTransport transport = new TSocket("localhost", 9090)) {
        	transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            ContactService.Client client = new ContactService.Client(protocol);
            return client.saveContact(contact);
        } catch (Exception e) {
            logger.error("Server connection error", e);
        }

        return false;
    }

    public ContactResource getContact(int id) {
        try (TTransport transport = new TSocket("localhost", 9090)) {
        	transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            ContactService.Client client = new ContactService.Client(protocol);
            return client.getContact(id);
        } catch (Exception e) {
            logger.error("Server connection error", e);
        }

        return null;
    }

    public List<ContactResource> getContactList() {
        try (TTransport transport = new TSocket("localhost", 9090)) {
        	transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            ContactService.Client client = new ContactService.Client(protocol);
            return client.getContactList();
        } catch (Exception e) {
            logger.error("Server connection error", e);
        }

        return null;
    }
}
