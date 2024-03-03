package ContactService;
import java.util.HashMap;
import java.util.Map;

public class Contact_Service {

    private Map<String, Contact> contacts;

    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, Contact> contacts) {
        if (contacts == null) {
            throw new IllegalArgumentException("Contacts cannot be null");
        }
        this.contacts = contacts;
    }

    public Contact_Service() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact with the same ID already exists");
        }
        if (contact.getPhone().length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
        contacts.put(contact.getContactID(), contact);
    }

    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactID);
    }

    public void updateContactField(String contactID, String field, String value) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        switch (field) {
            case "firstName":
                contact.setFirstName(value);
                break;
            case "lastName":
                contact.setLastName(value);
                break;
            case "phone":
                if (value.length() != 10) {
                    throw new IllegalArgumentException("Phone number must be exactly 10 digits");
                }
                contact.setPhone(value);
                break;
            case "address":
                if (value.length() > 30) {
                    throw new IllegalArgumentException("Address length cannot exceed 30 characters");
                }
                contact.setAddress(value);
                break;
            default:
                throw new IllegalArgumentException("Invalid field");
        }
    }
}
