const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');
const cors = require('cors');
const mongoose = require('mongoose');
require('./models/Users');
const Users = mongoose.model('Users');
const status = require('http-status');

mongoose.promise = global.Promise;
const app = express();

//Configure our app
app.use(cors());
app.use(bodyParser.urlencoded({
    extended: false
}));
app.use(bodyParser.json());

//Configure Mongoose
mongoose.connect('mongodb://localhost/test');

app.get('/', function (req, res) {
    res.send('API running!!')
});

app.post('/api/auth', async function (req, res) {
    const {email, password} = req.body;
    const user = await Users.findOne({email:email, password:password}).lean();
    console.log(user);
    if(user){
        res.json(user);
    }else{
        res.sendStatus(status.UNAUTHORIZED);
    }
});

app.listen(8000, () => console.log('Server running on http://localhost:8000/'));
