/**
 * dbconnectionmgr.js
 */
"use strict";
const mysql = require("mysql2");
const dbConfig = require("./dbconfig");

const dbConectionMgr = (function(dbConfig) {

    /**
     * Makes and returns a Database Connection pool using the given config
     */
    const getConnection = function() {
        return mysql.createPool(dbConfig);
    }
    return {
        getConnection: getConnection
    }
})(dbConfig);

module.exports = dbConectionMgr;
