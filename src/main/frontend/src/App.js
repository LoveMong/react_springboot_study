import './App.css';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Main from './components/Main';
import About from './components/About';
import Signup from './components/Signup';
import Nav from './components/Nav';
import Header from './components/Header';

function App() {
    return (
      <BrowserRouter>
          <div>
              <header />
              <Nav />
              <Routes>
                  <Route path="/" element={<Main />}/>
                  <Route path="/about" element={<About />}/>
                  <Route path="/signup" element={<Signup />}/>
              </Routes>
          </div>
      </BrowserRouter>
    );
}
export default App;
