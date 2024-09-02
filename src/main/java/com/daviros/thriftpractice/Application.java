package com.daviros.thriftpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.daviros.thriftpractice.client.ContactServiceClient;
import com.daviros.thriftpractice.service.impl.ContactResource;

public class Application {

	private final static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ContactServiceClient client = new ContactServiceClient();
		if (client.ping()) {
			ContactResource contact = new ContactResource();
			logger.info("Save Contact (id=0): " + client.saveContact(contact));

			contact.setId(1);
			logger.info("Save Contact (id=1): " + client.saveContact(contact));

			logger.info("Get Contact: " + client.getContact(1));
			logger.info("Get Contact List: " + client.getContactList());
		}
	}

}
