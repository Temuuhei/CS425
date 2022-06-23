/**
 * productController.js
 */
"use strict";

const patientDAO = require("../db/dao/patientDAO");
const Patient = require("../model/patient");

const patientController = (function(){
    const getPatients = async function(req, res) {
        try {
            const patients = await patientDAO.getPatients();
            pId = patients.length;
            // console.log(`Controller: Patient list: ${patients}`);
            return patients;
        } catch (error) {
            res.status(500);
            res.render("50x", {error: error});
        }
    };

    var pId;
    // console.log("11111111" , pId);

    const addNewPatient = async function(req, res) {
        
        // console.log("bodyyyy : " , req.body);
        const patient = new Patient(pId, req.body.patientIdNumber, req.body.fullName, req.body.emailAddress,
                                    req.body.contactPhoneNumber, req.body.dateOfBirth, req.body.ddlDepartment, req.body.radioIsOutPatient);
        try {
            const opRes = await patientDAO.savePatient(patient);
            console.log(`PatientController: Save Patient output: ${opRes}`);
            return opRes;
        } catch (error) {
            res.status(500);
            res.render("50x", {error: error});
        }
    }

    return {
        getPatients: getPatients,
        addNewPatient: addNewPatient
    }
})();

module.exports = patientController;