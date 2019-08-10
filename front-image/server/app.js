const express = require('express');
const app = express();

const PORT = process.env.PORT || 4200;
const DIST_FOLDER = __dirname + '/../dist/front-image';

const ngExpressEngine = require('@nguniversal/express-engine').ngExpressEngine;
app.engine('html', ngExpressEngine({}));

app.set('view engine', 'html');
app.set('views', DIST_FOLDER);
app.use(express.static(DIST_FOLDER));

app.get('*.*', express.static(DIST_FOLDER, {
  maxAge: '1y'
}));

let routes = {
  api: {
    image: require('./api/get')
  }
};

app.use(express.json());
app.use(express.urlencoded({extended: false}));

app.get('/api/get', routes.api.image);

app.get('*', (req, res) => {
  res.render('index', {req});
});

app.listen(PORT, () => {
  console.log(`Node Express server listening on http://localhost:${PORT}`);
});
