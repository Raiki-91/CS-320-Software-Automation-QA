package ContactService;
import java.util.HashMap;
import java.util.Map;

public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// default constructor
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        validateContactFields(contactID, firstName, lastName, phone, address);

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
	//setter and getters
	public String getContactID() {
		return contactID;
	}
	public void setContactID(String contactID) {
		this.contactID = contactID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

// field validation check	
private void validateContactFields(String contactID, String firstName, String lastName, String phone, String address) {
	if(contactID == null || contactID.length() > 10) {
		throw new IllegalArgumentException("Invaild contact ID");
	}
	
	if(firstName == null || firstName.length() > 10) {
		throw new IllegalArgumentException("Invaild First name");
	}
	
	if(lastName ==null || lastName.length() > 10) {
		throw new IllegalArgumentException("Invaild Last name");
	}
	
	if(phone == null || phone.length() > 10) {
		throw new IllegalArgumentException("Invalid Phone number");
	}
	
	if(address == null || address.length() > 30) {
		throw new IllegalArgumentException("Invalid Address");
	}
}
}