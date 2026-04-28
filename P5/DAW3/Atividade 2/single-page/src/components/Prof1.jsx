import React from "react";
import "../App.css"

export default function Prof1() {
    return (
        <div className="card-prof">
            <h1>Professor Rodolfo</h1>

            <table className="table-prof">
                <thead>
                    <tr>
                        <th>Disciplina</th>
                        <th>Curso</th>
                        <th>Período</th>
                    </tr>
                </thead>
                <tbody>

                    <tr>
                        <td>Desenvolvimento de Aplicações Web 3</td>
                        <td>ADS</td>
                        <td>5°</td>
                    </tr>

                    <tr>
                        <td>Inteligência Artificial</td>
                        <td>ADS</td>
                        <td>5°</td>
                    </tr>
                </tbody>

            </table>
        </div>
    )
}