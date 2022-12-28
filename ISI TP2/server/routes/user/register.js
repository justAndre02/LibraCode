const express = require('express');
const db = require('../../db');
const router = express.Router();

router.post('/', async (req, res, next) => {
  try {
      let results = await db.registo(req.body);
      res.json(results);
  }catch(e) {
      console.log(e);
      res.sendStatus(500);
  }
});


module.exports = router;
