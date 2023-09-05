const express = require('express');
const sqlite3 = require('sqlite3').verbose();

const app = express();
const db = new sqlite3.Database('userdb.db');

app.use(express.urlencoded({ extended: true}));
app.use(express.static('public')); // serviamo i file statici contenuti dentro /public

db.serialize(() => {
    db.run('CREATE TABLE IF NOT EXISTS users (name TEXT, email TEXT, newsletter INTEGER, usertype TEXT)')
});

app.get('/', (req, res) => {
    res.sendFile(__dirname + '/public/index.html');
});

app.post('/submit', (req, res) => {
    const { name, email, newsletter, usertype } = req.body;
    const newsletterValue = newsletter ? newsletter : "off";
    const stmt = db.prepare('INSERT INTO users VALUES (?, ?, ?, ?)');
    stmt.run(name, email, newsletterValue, usertype);
    stmt.finalize();
    res.send('Dati inseriti correttamente!');
});

app.listen(3000, () => {
    console.log('Server avviato sulla porta 3000');
});