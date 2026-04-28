import React from "react";
import "../App.css"

export default function Prof2() {
    return (

        <div className="card-prof">

            <h1>
                Professor Hugo
            </h1>

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
                        <td>Bancos de Dados 1</td>
                        <td>ADS</td>
                        <td>3</td>
                    </tr>

                    <tr>
                        <td>Bancos de Dados 2</td>
                        <td>ADS</td>
                        <td>4°</td>
                    </tr>
                </tbody>
            </table>

        </div>


    )
}