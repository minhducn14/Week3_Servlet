package modal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {
	private String firstName, lastName, email, mobileNumber, address, city, pinCode, state, country, courseAppliesFor;

	private LocalDate dob;

	private boolean gender;

	private ArrayList<String> hobbies;

	private String[][] qualification;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCourseAppliesFor() {
		return courseAppliesFor;
	}

	public void setCourseAppliesFor(String courseAppliesFor) {
		this.courseAppliesFor = courseAppliesFor;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

	public String[][] getQualification() {
		return qualification;
	}

	public void setQualification(String[][] qualification) {
		this.qualification = qualification;
	}

	public Student(String firstName, String lastName, LocalDate dob, String email, String mobileNumber, String address,
			String city, String pinCode, String state, String country, String courseAppliesFor, boolean gender,
			ArrayList<String> hobbies, String[][] qualification) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
		this.courseAppliesFor = courseAppliesFor;
		this.gender = gender;
		this.hobbies = hobbies;
		this.qualification = qualification;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String hobbies = "";
		for (String hobby : this.hobbies) {
			hobbies += hobby + ", ";
		}

		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", address=" + address + ", city=" + city + ", pinCode=" + pinCode
				+ ", state=" + state + ", country=" + country + ", courseAppliesFor=" + courseAppliesFor + ", gender="
				+ gender + ", hobbies=" + hobbies + ", qualification=" + Arrays.toString(qualification) + "]";
	}
}