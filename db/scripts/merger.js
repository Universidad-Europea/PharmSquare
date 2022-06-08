let tablas = [
	{
		nombreTabla: "CLIENTE",
		estructura: [
			"dni",
			"nombre",
			"fecha_alta",
			"direccion",
			"nacimiento",
			"passwd",
			"sexo",
			"telefono",
			"mail"
		],
		showEstructura: false,
		datos: {
			total: 5,
			dni: [
				"000000000A",
				"123456789A",
				"987654321A",
				"123456789B",
				"987654321B"
			],
			nombre: [
				"no registrado",
				"Juan",
				"Pedro",
				"Maria",
				"Ana"
			],
			fecha_alta: [
				null,
				"2019-01-01",
				"2019-01-01",
				"2019-01-01",
				"2019-01-01"
			],
			direccion: [
				null,
				"C/Calle m nº 1",
				"C/Calle m nº 2",
				"C/Calle m nº 3",
				"C/Calle m nº 4"
			],
			nacimiento: [
				null,
				"1990-01-01",
				"1990-01-01",
				"1990-01-01",
				"1990-01-01"
			],
			passwd: [
				null,
				"12ab34!!",
				"12ab34!!",
				"12ab34!!",
				"12ab34!!"
			],
			sexo: [
				'O',
				'H',
				'H',
				'M',
				'M'
			],
			telefono: [
				null,
				"666666666",
				"666666666",
				"666666666",
				"666666666"
			],
			mail: [
				null,
				"juan@gmail.com",
				"pedro@gmail.com",
				"maria@gmail.com",
				"ana@gmail.com"
			]
		}
	},
	{
		nombreTabla: "PRODUCTO",
		estructura: [
			// "id",
			"nombre",
			"utilidad",
			"laboratorio",
			"precio",
			"stock",
			"foto",
			"necesita_login"
		],
		showEstructura: true,
		datos: {
			total: 14,
			// id: "ID",
			nombre: [
				"Bendaje de piel",
				"Ibuprofeno",
				"Paracetamol",
				"Aspirina",
				"Ebastel",
				"Crema solar",
				"Suero",
				"Cafeina",
				"Suplemento alimenticio bebes",
				"Suplemento alimenticio adultos",
				"Suplemento alimenticio niños",
				"Crema hidratante",
				"Tiritas",
				"Apósitos de nitrato de plata"
			],
			utilidad: [
				"Utilidad 1",
				"Utilidad 2",
				"Utilidad 3",
				"Utilidad 4",
				"Utilidad 5",
				"Utilidad 6",
				"Utilidad 7",
				"Utilidad 8",
				"Utilidad 9",
				"Utilidad 10",
				"Utilidad 11",
				"Utilidad 12",
				"Utilidad 13",
				"Utilidad 14"
			],
			laboratorio: [
				"Laboratorio 1",
				"Laboratorio 1",
				"Laboratorio 3",
				"Laboratorio 4",
				"Laboratorio 5",
				"Laboratorio 6",
				"Laboratorio 5",
				"Laboratorio 6",
				"Laboratorio 6",
				"Laboratorio 2",
				"Laboratorio 3",
				"Laboratorio 4",
				"Laboratorio 5",
				"Laboratorio 6"
			],
			precio: [
				9.99,
				9.99,
				9.99,
				9.99,
				9.99,
				9.99,
				9.99,
				9.99,
				9.99,
				9.99,
				9.99,
				9.99,
				9.99,
				9.99
			],
			stock: [
				10,
				10,
				10,
				10,
				10,
				10,
				10,
				10,
				10,
				10,
				10,
				10,
				10,
				10
			],
			foto: [
				"./res/img/productos/bendaje.jpg",
				"./res/img/productos/ibuprofeno.jpg",
				"./res/img/productos/paracetamol.jpg",
				"./res/img/productos/aspirina.jpg",
				"./res/img/productos/ebastel.jpg",
				"./res/img/productos/crema_solar.jpg",
				"./res/img/productos/suero.jpg",
				"./res/img/productos/cafeina.jpg",
				"./res/img/productos/suplemento_bebes.jpg",
				"./res/img/productos/suplemento_adultos.jpg",
				"./res/img/productos/suplemento_ninos.jpg",
				"./res/img/productos/crema_hidratante.jpg",
				"./res/img/productos/tiritas.jpg",
				"./res/img/productos/apositos.jpg"
			],
			necesita_login: [
				"S",
				"S",
				"S",
				"S",
				"S",
				"N",
				"S",
				"S",
				"N",
				"N",
				"N",
				"N",
				"N",
				"N"
			]
		}
	},
	{
		nombreTabla: "CATEGORIA_PRODUCTO",
		estructura: [
			// "id",
			"nombre",
		],
		showEstructura: true,
		datos: {
			total: 4,
			// id: "ID",
			nombre: [
				"Suplementos",
				"Higiene",
				"Medicamentos",
				"Belleza"
			]
		}
	},
	{
		nombreTabla: "CATEGORIAS_PRODUCTO",
		estructura: [
			"id_producto",
			"id_categoria"
		],
		showEstructura: false,
		datos: {
			total: 14,
			id_producto: [
				1,
				2,
				3,
				4,
				5,
				6,
				7,
				8,
				9,
				10,
				11,
				12,
				13,
				14
			],
			id_categoria: [
				1,
				1,
				1,
				1,
				2,
				2,
				2,
				2,
				3,
				3,
				3,
				3,
				4,
				4
			]
		}
	},
	{
		nombreTabla: "TRANSACCION",
		estructura: [
			"dni_cliente",
			"id_producto",
			"fecha",
			"cantidad"
		],
		showEstructura: true,
		datos: {
			total: 7,
			dni_cliente: [
				"000000000A",
				"000000000A",
				"000000000A",
				"000000000A",
				"000000000A",
				"000000000A",
				"000000000A"
			],
			id_producto: [
				2,
				1,
				2,
				3,
				4,
				5,
				6
			],
			fecha: [
				"DATETIME('2022-02-01 12:42')",
				"DATETIME('2022-02-01 13:42')",
				"DATETIME('2022-02-01 11:42')",
				"DATETIME('2022-02-01 10:42')",
				"DATETIME('2022-02-01 14:42')",
				"DATETIME('2022-02-01 15:42')",
				"DATETIME('2022-02-01 16:42')"
			],
			cantidad: [
				1,
				2,
				3,
				4,
				5,
				6,
				7
			]
		}
	},
	{
		nombreTabla: "PERSONAL",
		estructura: [
			"dni",
			"nombre",
			"passwd",
			"categoria"
		],
		showEstructura: true,
		datos: {
			total: 3,
			dni: [
				"123456789E",
				"123456789C",
				"123456789D",
			],
			nombre: [
				"EMPLEADO GENERICO UNO",
				"EMPLEADO GENERICO DOS",
				"ADMINISTRADOR DE FARMACIA",
			],
			passwd: [
				"aBc23!@",
				"aBc23!@",
				"pfSG$%@"
			],
			categoria: [
				"EMPLEADO",
				"EMPLEADO",
				"ADMINISTRADOR"
			]
		}
	}
];

function data2sql(data) {
	// CONST
	const firstId = 1;
	const TAB = ""
	// const TAB = "    "
	let OPERATION = `${TAB}INSERT INTO ${data.nombreTabla}`;

	if (data.showEstructura) {
		OPERATION += ` (${data.estructura.join(", ")})`;
	}
	OPERATION += `\n${TAB}VALUES (`;

	let str = "-- Rellenar " + data.nombreTabla + "\n\n";

	// if (data.estructura[0].match("ID") || data.datos[data.estructura[0]] == "ID") {
	// 	str += `${TAB}CREATE SEQUENCE ${data.nombreTabla}_SEQ\n`;
	// 	str += `${TAB}START WITH ${firstId} INCREMENT BY 1\n${TAB}MINVALUE 1 MAXVALUE 9999 CACHE 4 ORDER;\n\n`;
	// }

	let elements, values;
	for (let i = 0, j; i < data.datos.total; i++) {
		str += OPERATION;
		elements = [];
		for (j = 0; j < data.estructura.length; j++) {
			values = data.datos[data.estructura[j]];
			if (values == "ID") {
				elements.push(`${data.nombreTabla}_SEQ.NEXTVAL`);
			}
			else if (values == null || values[i] == null) {
				elements.push("NULL");
			}
			else {
				let border = "";
				if (typeof data.datos[data.estructura[j]][i] == "string" && data.estructura[j] != "fecha") {
					border = "'";
				}
				elements.push(border + data.datos[data.estructura[j]][i] + border);
			}
		}
		str += elements.join(", ") + ");\n\n";
	}
	return str;
	// return str + "END";
}

// Get the name of this file
let fileName = __filename.split("/").pop();

console.log("-- Script generado usando nodejs\n-- Para editar el archivo, usa el commando:\n--\t\tnodejs " +
			fileName + " > datos_db.sql\n\n")
for (let i = 0; i < tablas.length; i++) {
	console.log(data2sql(tablas[i]));
}