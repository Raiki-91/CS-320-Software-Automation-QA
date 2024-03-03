package ContactService;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test // initializing valid contact 
	public void testContactInitialization() {
		Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
		
		// testing initialization of valid contact
		assertEquals("123", contact.getContactID());
		assertEquals("John", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Main St", contact.getAddress());
	}
	
	@Test // testing validation exceptions for all fields 
	public void testInvalidContactId() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Doe", "1234567890", "123 Main St");
	        });

	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
	        });
	    }

	@Test
	public void testInvalidFirstName() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123", null, "Doe", "1234567890", "123 Main St");
	        });

	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123", "John1234567", "Doe", "1234567890", "123 Main St");
	        });
	    }

	@Test
	public void testInvalidLastName() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123", "John", null, "1234567890", "123 Main St");
	        });

	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123", "John", "Doe12345678", "1234567890", "123 Main St");
	        });
	    }

	@Test
	public void testInvalidPhone() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "John", "Doe", null, "123 Main St");
	        });

	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123", "John", "Doe", "12345678901", "123 Main St");
	        });
	    }

	@Test
	public void testInvalidAddress() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123", "John", "Doe", "1234567890", null);
	        });

	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("123", "John", "Doe", "1234567890", "1234567890123456789012345678901");
	        });
	    }		
	 @Test // Test setting and getting contact ID
	    public void testSetAndGetContactID() {
	        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
	        contact.setContactID("456");
	        assertEquals("456", contact.getContactID());
	    }

	    @Test // Test setting and getting first name
	    public void testSetAndGetFirstName() {
	        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
	        contact.setFirstName("Jane");
	        assertEquals("Jane", contact.getFirstName());
	    }

	    @Test // Test setting and getting last name
	    public void testSetAndGetLastName() {
	        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
	        contact.setLastName("Smith");
	        assertEquals("Smith", contact.getLastName());
	    }

	    @Test // Test setting and getting phone number
	    public void testSetAndGetPhone() {
	        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
	        contact.setPhone("9876543210");
	        assertEquals("9876543210", contact.getPhone());
	    }

	    @Test // Test setting and getting address
	    public void testSetAndGetAddress() {
	        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
	        contact.setAddress("456 Second St");
	        assertEquals("456 Second St", contact.getAddress());
	    }
}
