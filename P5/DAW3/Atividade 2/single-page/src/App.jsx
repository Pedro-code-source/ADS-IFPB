import { useState } from 'react'
import "./App.css"
import Inicio from './components/Inicio';
import Prof1 from './components/Prof1';
import Prof2 from './components/Prof2';
import Prof3 from './components/Prof3';
import Form from './components/Formulario';

function App() {
  const [pagina, setPagina] = useState("inicio");

  return (

     <div className="container">

      <nav>
  <button onClick={() => setPagina("inicio")}>Início</button>
  <button onClick={() => setPagina("prof1")}>Professor 1</button>
  <button onClick={() => setPagina("prof2")}>Professor 2</button>
  <button onClick={() => setPagina("prof3")}>Professor 3</button>
      </nav>

     
  {pagina === 'inicio' && <Inicio />}
  {pagina === 'prof1' && (<><Prof1 /><Form /></>)}
  {pagina === 'prof2' && (<><Prof2 /><Form /></>)}
  {pagina === 'prof3' && (<><Prof3 /><Form /></>)}
</div>

    
  )
}

export default App
