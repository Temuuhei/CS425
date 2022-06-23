/**
 * product.js
 */
"use strict";

// TODO: use ES6 class syntax
function Patient(patientIdNumber, 
                fullName, emailAddress, contactPhoneNumber, dateOfBirth, ddlDepartment, isAnOutPatient) {
    this.patientId = null;
    this.patientIdNumber = patientIdNumber;
    this.fullName = fullName;
    this.emailAddress = emailAddress;
    this.contactPhoneNumber = contactPhoneNumber;
    this.dateOfBirth = dateOfBirth;
    this.ddlDepartment = ddlDepartment;
    this.isAnOutPatient = isAnOutPatient;

}

module.exports = Patient;