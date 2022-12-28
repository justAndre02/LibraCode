const express = require('express');
const apiRouter = require('./routes');
const swaggerUi = require('swagger-ui-express');
const swaggerDocument = require('../swagger.json');

const app = express();

app.use(express.json());

app.use('/api/livros', apiRouter);
app.use('/api/docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));


app.listen(process.env.PORT || '3000', () => {

    console.log("Server running on port: ${process.env.PORT || '3000' }");
})