import React, { useState } from 'react'
import Modal from './Modal.jsx'

function App() {
  const [showModal, setShowModal] = useState(false);
  const [nome, setNome] = useState("");
  const [periodo, setPeriodo] = useState(0);
  const [descricao, setDescricao] = useState("");
  const [curso, setCurso] = useState("");
  const [professor, setProfessor] = useState("");
  const [qntdd, setQntdd] = useState(0);

  return (
    <div id='form-cadastro'>

        {!showModal && (
            <form action="submit">

        <label>Nome da Disciplina: </label>
        <input type="text" value={nome} onChange={e =>{
          setNome(e.target.value);
        }}/>
        
        <label>Descrição da disciplina: </label>
        <input type="text" value={descricao} onChange={e => {
          setDescricao(e.target.value);
        }} />
        
        <label>Curso</label>
        <input type="text" value={curso} onChange={e => {
          setCurso(e.target.value);
        }}/>
        
        <label>Período</label>
        <input type="number" value={periodo} onChange={e => {
          setPeriodo(e.target.value);
        }} />
        
        <label>Professor</label>
        <input type="text" value={professor} onChange={e => {
          setProfessor(e.target.value);
        }}/>
        
        <label>Quantidade de Alunos</label>
        <input type="number" value={qntdd} onChange={e => {
          setQntdd(e.target.value);
        }}/>
        
        <button onClick={e => {
          e.preventDefault()
          setShowModal(true)
        }}>Submit</button>
      </form>
        )}
      
      {showModal && <Modal
      nome = {nome}
      descricao = {descricao}
      curso = {curso}
      periodo = {periodo}
      professor = {professor}
      qntdd = {qntdd}/>}

    </div>
  )
}

export default App
