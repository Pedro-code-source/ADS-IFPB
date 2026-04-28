import { useState } from 'react'
import Inicio from './components/Inicio';
import Prof1 from './components/Prof1';
import Prof2 from './components/Prof2';
import Prof3 from './components/Prof3';
import Form from './components/Formulario';

function App() {
  const [pagina, setPagina] = useState("inicio");

  return (

    <div>

      <ul>

        <button onClick={e => {
          e.preventDefault()
          setPagina("inicio")
        }}><li>Início</li></button>

        <button onClick={e => {
          e.preventDefault()
          setPagina("prof1")
        }}><li>Professor 1</li></button>

        <button onClick={e => {
          e.preventDefault()
          setPagina("prof2")
        }}><li>Professor 2</li></button>
        
        <button onClick={e => {
          e.preventDefault()
          setPagina("prof3")
        }}><li>Professor 3</li></button>
        
      </ul>
          {pagina === 'inicio' && <Inicio/>}
          {pagina === 'prof1' && (<><Prof1/> <Form/></>)}
          {pagina === 'prof2' && (<><Prof2/> <Form/></>)}
          {pagina === 'prof3' && (<><Prof3/> <Form/></>)}

    </div>
  )
}

export default App
