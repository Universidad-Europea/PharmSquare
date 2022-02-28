let tablas = [
	{
		nombreTabla: "CLIENTE",
		estructura: [
			"dni",
			"nombre",
			"fecha_alta",
			"direccion",
			"nacimiento",
			"contraseña",
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
			contraseña: [
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
		nombreTabla: "HISTORIAL",
		estructura: [
			"id",
			"fecha",
			"dni",
			"diagnostico"
		],
		showEstructura: false,
		datos: {
			total: 14,
			id: "ID",
			fecha: [
				"2019-01-01",
				"2019-01-02",
				"2019-01-03",
				"2019-01-04",
				"2019-01-05",
				"2019-01-06",
				"2019-01-07",
				"2019-01-08",
				"2019-01-09",
				"2019-01-10",
				"2019-01-11",
				"2019-01-12",
				"2019-01-13",
				"2019-01-14"
			],
			dni: [
				"123456789A",
				"123456789A",
				"123456789B",
				"123456789B",
				"987654321A",
				"123456789B",
				"987654321B",
				"123456789A",
				"123456789A",
				"123456789B",
				"123456789B",
				"987654321A",
				"123456789B",
				"987654321B"
			],
			diagnostico: [
				"diagnostico 1",
				"diagnostico 2",
				"diagnostico 3",
				"diagnostico 4",
				"diagnostico 5",
				"diagnostico 6",
				"diagnostico 7",
				"diagnostico 8",
				"diagnostico 9",
				"diagnostico 10",
				"diagnostico 11",
				"diagnostico 12",
				"diagnostico 13",
				"diagnostico 14"
			]
		}
	},
	{
		nombreTabla: "CATEGORIA_HISTORIAL",
		estructura: [
			"id",
			"nombre"
		],
		showEstructura: false,
		datos: {
			total: 14,
			id: "ID",
			nombre: [
				"CIRUGIA",
				"CONSULTA",
				"ODONTOLOGIA",
				"PSICOLOGIA",
				"TRAUMATOLOGIA",
				"OFTALMOLOGIA",
				"OTORRINOLARINGOLOGIA",
				"NEUROLOGIA",
				"NEFROLOGIA",
				"NEUROCIRUGIA",
				"NEUROPATOLOGIA",
				"FISIOTERIAPIA",
				"ALERGIA",
				"CARDIOPATIA"
			]
		}
	},
	{
		nombreTabla: "CATEGORIAS_HISTORIAL",
		estructura: [
			"id_historial",
			"id_categoria",
		],
		showEstructura: false,
		datos: {
			total: 25,
			id_historial: [
				1,
				1,
				1,
				2,
				2,
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
				14,
				15,
				16,
				17,
				18,
				19,
				20,
				20
			],
			id_categoria: [
				3,
				1,
				2,
				1,
				2,
				3,
				1,
				2,
				7,
				9,
				5,
				6,
				8,
				4,
				3,
				1,
				2,
				3,
				1,
				9,
				5,
				6,
				8,
				4,
				3,
				1,
				2,
				3
			]
		}
	},
	
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

	if (data.estructura[0].match("ID") && data.datos[data.estructura[0]] == "ID") {
		str += `${TAB}CREATE SEQUENCE ${data.nombreTabla}_SEQ\n`;
		str += `${TAB}START WITH ${firstId} INCREMENT BY 1\n${TAB}MINVALUE 1 MAXVALUE 9999 CACHE 4 ORDER;\n\n`;
	}

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
				if (typeof data.datos[data.estructura[j]][i] == "string") {
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

for (let i = 0; i < tablas.length; i++) {
	console.log(data2sql(tablas[i]));
}