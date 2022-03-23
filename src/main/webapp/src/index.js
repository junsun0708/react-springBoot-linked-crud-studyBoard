import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
//import App from './App';
//import App from './testStudy/class1/App';
//import App from './testStudy/class2/App';
//import App from './testStudy/class6/App';
//import App from './testStudy/class7/App';
//import App from './testStudy/class7/App1';
//import App from './testStudy/class8/App_tui_test_error';
//import App from './testStudy/class8/App';
import App from './testStudy/class8-1/App';
//import App from './testBoard/App';

/*
ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);
*/

//class7 app1
const styleLink = document.createElement("link");
styleLink.rel = "stylesheet";
styleLink.href =
  "https://cdn.jsdelivr.net/npm/semantic-ui/dist/semantic.min.css";

document.head.appendChild(styleLink);
const rootElement = document.getElementById("root");
ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  rootElement
);
