package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Servlet implementation class RegistrationForm
 */
public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationForm() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get data from form
		String fname = request.getParameter("txtFName");
		String lname = request.getParameter("txtLName");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String email = request.getParameter("txtEmail");
		String mobileNumber = request.getParameter("txtMobileNumber");
		String gender = request.getParameter("gender");
		String address = request.getParameter("txtAddress");
		String city = request.getParameter("txtCity");
		String pincode = request.getParameter("txtPinCode");
		String state = request.getParameter("txtState");
		String country = request.getParameter("txtCountry");
		String hobbies = request.getParameter("chkHobbies");
		String course = request.getParameter("txtCourse");

		LocalDate dob = null;
		if (day != null && !day.isEmpty() && month != null && !month.isEmpty() && year != null && !year.isEmpty()) {
			try {
				// Ensure day and month have two digits
				String formattedDay = String.format("%02d", Integer.parseInt(day));
				String formattedMonth = String.format("%02d", Integer.parseInt(month));

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				dob = LocalDate.parse(year + "-" + formattedMonth + "-" + formattedDay, dtf);
			} catch (Exception e) {
				System.out.println("Error parsing date: " + e.getMessage());
			}
		}
		// Set data to Student
		Student sv = new Student();
		sv.setFirstName(fname);
		sv.setLastName(lname);
		sv.setEmail(email);
		sv.setGender(gender.equals("Male") ? true : false);
		sv.setMobileNumber(mobileNumber);
		sv.setAddress(address);
		sv.setCity(city);
		sv.setPinCode(pincode);
		sv.setState(state);
		sv.setCountry(country);
		sv.setDob(dob);
		sv.setCourseAppliesFor(course);
		ArrayList<String> hobbiesList = new ArrayList<String>();
		String[] hobbiesArray = hobbies.split(",");
		for (String hobby : hobbiesArray) {
			hobbiesList.add(hobby);
		}
		if (hobbiesList.contains("Others")) {
			String otherString = request.getParameter("txtOtherHobby");
			hobbiesList.remove("Others");
			hobbiesList.add(otherString);
		}
		sv.setHobbies(hobbiesList);
		// Set qualification
		String[][] qualification = new String[4][4];
		qualification[0][0] = request.getParameter("txt10School");
		qualification[0][1] = request.getParameter("txt10Percentage");
		qualification[0][2] = request.getParameter("txt10Year");

		qualification[1][0] = request.getParameter("txt12School");
		qualification[1][1] = request.getParameter("txt12Percentage");
		qualification[1][2] = request.getParameter("txt12Year");

		qualification[2][0] = request.getParameter("txtGraduationCollege");
		qualification[2][1] = request.getParameter("txtGraduationPercentage");
		qualification[2][2] = request.getParameter("txtGraduationYear");

		qualification[3][0] = request.getParameter("txtPostGraduationCollege");
		qualification[3][1] = request.getParameter("txtPostGraduationPercentage");
		qualification[3][2] = request.getParameter("txtPostGraduationYear");
		sv.setQualification(qualification);

		// Set object student to request object
		request.setAttribute("student", sv);

		// Forward to result-form.jsp
		RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
		rd.forward(request, response);
	}
}
