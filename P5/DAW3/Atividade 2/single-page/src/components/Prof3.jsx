import React from "react";
import "../App.css"

export default function Prof3() {
    return (

        <div className="card-prof">

            <h1>Professora Renata</h1>

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
                        <td>Estruturas de Dados</td>
                        <td>ADS</td>
                        <td>3°</td>
                    </tr>

                    <tr>
                        <td>Redes de Computadores</td>
                        <td>ADS</td>
                        <td>2°</td>
                    </tr>
                </tbody>
            </table>

        </div>

    )
}