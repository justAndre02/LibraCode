var express = require('express');
var cors = require('cors');
var bodyParser = require('body-parser');
var path = require('path');
var session = require('express-session');
var cookieParser = require("cookie-parser");

const swaggerUi = require('swagger-ui-express');
const swaggerDocument = require('../swagger.json');

const utilizador_router = require('./routes/user/user');
const livro_router = require('./routes/livro/livro');
const emprestimo_router = require('./routes/emprestimo/emprestimo');


const app = express();
// creating 24 hours from milliseconds
const oneDay = 1000 * 60 * 60 * 24;
path.basename(__dirname);

app.use(session({
  secret: 'keyboard cat',
  resave: false,
  saveUninitialized: true,
  cookie: { maxAge: oneDay }
}));
app.use(cors());
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

//serving public file
app.use(express.static(path.join(__dirname,"public")));

// cookie parser middleware
app.use(cookieParser());

app.use("/livro",livro_router)
app.use("/user",utilizador_router);
app.use("/emprestimo",emprestimo_router);
app.use('/api/docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));


if (process.env.NODE_ENV == 'test') {
  app.listen(process.env.PORT || '0');
}
else{
  app.listen(process.env.PORT || '3000', () => {
    console.log(`Server is running on port: ${process.env.PORT || '3000'}`);
    console.log(`Server is running on url: http://localhost:${process.env.PORT || '3000'}`);
  });
}

module.exports = app;