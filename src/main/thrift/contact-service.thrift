namespace java com.daviros.thriftpractice.service.impl

typedef i32 int

exception ServiceException {
    1: int code,
    2: string description
}

struct ContactResource {
    1: int id,
    2: string name,
    3: optional string salutation
}

service ContactService {

    ContactResource getContact(1:int id) throws (1:ServiceException e),

    bool saveContact(1:ContactResource contact) throws (1:ServiceException e),

    list <ContactResource> getContactList() throws (1:ServiceException e),

    bool ping() throws (1:ServiceException e)
}
