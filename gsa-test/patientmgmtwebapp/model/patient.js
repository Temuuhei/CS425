/**
 * product.js
 */
"use strict";

// TODO: use ES6 class syntax
function Patient(patientId, patientIdNumber, 
                fullName, emailAddress, contactPhoneNumber, dateOfBirth, ddlDepartment, isAnOutPatient) {
    this.patientId = patientId;
    this.patientIdNumber = patientIdNumber;
    this.fullName = fullName;
    this.emailAddress = emailAddress;
    this.contactPhoneNumber = contactPhoneNumber;
    this.dateOfBirth = dateOfBirth;
    this.ddlDepartment = ddlDepartment;
    this.isAnOutPatient = isAnOutPatient;

}

module.exports = Patient;