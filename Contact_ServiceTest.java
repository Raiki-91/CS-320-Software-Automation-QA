package ContactService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class Contact_ServiceTest {

    // Test adding a contact and verifying its presence in the contacts map
    @Test
    public void testAddContact() {
        Contact_Service contactService = new Contact_Service();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertTrue(contactService.getContacts().containsKey("123"));
    }

    // Test deleting a contact and verifying its absence in the contacts map
    @Test
    public void testDeleteContact() {
        Contact_Service contactService = new Contact_Service();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("123");
        assertFalse(contactService.getContacts().containsKey("123"));
    }

    // Test updating a contact field and verifying the updated value
    @Test
    public void testUpdateContactField() {
        Contact_Service contactService = new Contact_Service();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContactField("123", "firstName", "Jane");
        assertEquals("Jane", contactService.getContacts().get("123").getFirstName());
    }

    // Test adding a contact with an invalid phone number length
    @Test
    public void testAddContactWithInvalidPhoneNumber() {
        Contact_Service contactService = new Contact_Service();
        Contact contact = new Contact("123", "John", "Doe", "123", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact));
    }

    // Test adding a duplicate contact and verifying that it throws an IllegalArgumentException
    @Test
    public void testAddDuplicateContact() {
        Contact_Service contactService = new Contact_Service();
        Contact contact1 = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("123", "Jane", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }

    // Test deleting a non-existent contact and verifying that it throws an IllegalArgumentException
    @Test
    public void testDeleteNonExistentContact() {
        Contact_Service contactService = new Contact_Service();
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("123"));
    }

    // Test updating a field of a non-existent contact and verifying that it throws an IllegalArgumentException
    @Test
    public void testUpdateNonExistentContactField() {
        Contact_Service contactService = new Contact_Service();
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactField("123", "firstName", "Jane"));
    }

    // Test updating a contact field with an invalid field name and verifying that it throws an IllegalArgumentException
    @Test
    public void testUpdateInvalidField() {
        Contact_Service contactService = new Contact_Service();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactField("123", "invalidField", "value"));
    }

    // Test setting contacts to a non-null value and verifying that it updates the contacts map
    @Test
    public void testSetContactsNotNull() {
        Contact_Service contactService = new Contact_Service();
        Map<String, Contact> contacts = new HashMap<>();
        contacts.put("123", new Contact("123", "John", "Doe", "1234567890", "123 Main St"));
        contactService.setContacts(contacts);
        assertEquals(contacts, contactService.getContacts());
    }

    // Test setting contacts to null and verifying that it throws an IllegalArgumentException
    @Test
    public void testSetContactsNull() {
        Contact_Service contactService = new Contact_Service();
        assertThrows(IllegalArgumentException.class, () -> contactService.setContacts(null));
    }

    // Test updating the phone field of a contact with an invalid length and verifying that it throws an IllegalArgumentException
    @Test
    public void testUpdateContactFieldPhoneInvalidLength() {
        Contact_Service contactService = new Contact_Service();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactField("123", "phone", "123"));
    }

        // Test updating the firstName field
        @Test
        public void testUpdateContactFieldFirstName() {
            Contact_Service contactService = new Contact_Service();
            Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
            contactService.addContact(contact);
            contactService.updateContactField("123", "firstName", "Jane");
            assertEquals("Jane", contactService.getContacts().get("123").getFirstName());
        }

        // Test updating the lastName field
        @Test
        public void testUpdateContactFieldLastName() {
            Contact_Service contactService = new Contact_Service();
            Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
            contactService.addContact(contact);
            contactService.updateContactField("123", "lastName", "Smith");
            assertEquals("Smith", contactService.getContacts().get("123").getLastName());
        }

        // Test updating the phone field
        @Test
        public void testUpdateContactFieldPhone() {
            Contact_Service contactService = new Contact_Service();
            Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
            contactService.addContact(contact);
            contactService.updateContactField("123", "phone", "1234567890");
            assertEquals("1234567890", contactService.getContacts().get("123").getPhone());
        }

        // Test updating the address field
        @Test
        public void testUpdateContactFieldAddress() {
            Contact_Service contactService = new Contact_Service();
            Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
            contactService.addContact(contact);
            contactService.updateContactField("123", "address", "456 Second St");
            assertEquals("456 Second St", contactService.getContacts().get("123").getAddress());
        }

    }


