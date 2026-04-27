import React from "react"
import App from "./App"

export default function Modal({nome, descricao, curso, periodo, professor, qntdd}){
    return (
        <div id="modal">
            <p>Nome: {nome}</p>
            <p>Descrição: {descricao}</p>
            <p>Curso: {curso}</p>
            <p>Período: {periodo}</p>
            <p>Professor: {professor}</p>
            <p>Quantidade de Alunos: {qntdd}</p>
        </div>
    )
}