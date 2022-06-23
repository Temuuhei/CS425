/**
 * product.js
 */
"use strict";

const express = require("express");
const patientAPIRouter = express.Router();

const patientController = require("../../controller/patientController");

patientAPIRouter.get("/list", async (req, res) => {
    const patients = await patientController.getPatients(req, res);
    res.json(patients);
});

module.exports = patientAPIRouter;