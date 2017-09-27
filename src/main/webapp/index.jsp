<!DOCTYPE html>
<html>
<head>
<style>
.button {
	background-color: #555555;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body>




	<form action="/Maven2/api/PersonService/delete" method="post">
		<div align="center" style="color: green;">
			<h2>Personal Information</h2>
			<table>
				<tr>
					<td>Enter ID:</td>
					<td>Enter First Name:</td>
					<td>Enter Last Name:</td>
					<td>Phone Number</td>
				</tr>
				<tr>
					<td><input type="text" name="id"></td>
					<td><input type="text" name="firstname"></td>
					<td><input type="text" name="lastname"></td>
					<td><input type="text" name="phonenumber"></td>
				</tr>
			</table>
			<h2>Address</h2>
			<table>


				<tr>
					<td>Province:</td>
					<td>City:</td>
					<td>Main Street:</td>
					<td>Street:</td>

				</tr>

				<tr>
					<td><input type="text" name="province"></td>
					<td><input type="text" name="city"></td>
					<td><input type="text" name="mainstreet"></td>
					<td><input type="text" name="street"></td>

				</tr>
				<tr>
					<td></td>
					<td>Number:</td>
					<td>Zip Code:</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="text" name="number"></td>
					<td><input type="text" name="zipcode"></td>
				</tr>




			</table>
			<br></br>
			<div align="center" style="color: green;">

				<button
					onclick="form.action='/homework7/api/Person/AddPerson';form.method='POST';"
					class="button">Add</button>
				<button
					onclick="form.action='/homework7/api/Person/GetPerson';form.method='GET';"
					class="button">Show Information</button>
				<button
					onclick="form.action='/homework7/api/Person/GetAll';form.method='GET';"
					class="button">Show All</button>
				<button
					onclick="form.action='/homework7/api/Person/deletePerson';form.method='GET';"
					class="button">Delete</button>
				<button
					onclick="form.action='/homework7/api/Person/updatePerson';form.method='POST';"
					class="button">Modify</button>

			</div>
		</div>
	</form>
</body>
</html>
