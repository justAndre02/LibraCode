const express = require('express');
const apiRouterLivro = require('./routes/livro/index');
const apiRouterUser = require('./routes/user/register');
const swaggerUi = require('swagger-ui-express');
const swaggerDocument = require('../swagger.json');

const app = express();

app.use(express.json());

app.use('/api/docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));

app.use('/api/livros', apiRouterLivro);
app.use('/register', apiRouterUser);


app.listen(process.env.PORT || '3000', () => {

    console.log("Server running on port: ${process.env.PORT || '3000' }");
})