-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-12-2022 a las 13:19:09
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tpfinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `novedad`
--

CREATE TABLE `novedad` (
  `id_novedad` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `contenido` text NOT NULL,
  `img_id` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `novedad`
--

INSERT INTO `novedad` (`id_novedad`, `fecha`, `titulo`, `contenido`, `img_id`) VALUES
(1, '2022-10-30 00:00:00', 'Repro 2', 'El sistema para que las empresas tramiten, a través del sitio web de la AFIP, la inscripción al programa REPRO 2 estará habilitado entre el 25 y el 31 de octubre de 2021 inclusive. El Programa de Recuperación Productiva 2 es una herramienta diseñada por el Gobierno nacional para sostener el empleo en sectores con dificultades económicas en el marco de la pandemia del COVID-19. ', NULL),
(2, '2022-11-02 00:00:00', 'Programa Registradas', 'Con el objetivo de promover la formalización del empleo de las trabajadoras de casas particulares, el Gobierno Nacional pone en marcha Registradas. El programa consiste en la transferencia de una suma entre el 30% y 50% del salario durante 6 meses a las nuevas trabajadoras que sean registradas por sus empleadores. La iniciativa busca reducir la informalidad del sector, garantizar la permanencia en un empleo registrado y promover la bancarización. La inscripción al programa debe ser solicitada por la parte empleadora a través de la página web de la AFIP hasta el 31 de diciembre. ', NULL),
(3, '2022-11-01 00:00:00', 'Cambios en el Impuesto a las Ganancias', 'La Administración Federal de Ingresos Públicos (AFIP) reglamentó el incremento del nivel de ingresos salariales a partir del cual las trabajadoras y los trabajadores empiezan a pagar Impuesto a las Ganancias. La modificación comenzará a regir con los salarios de septiembre que se pagan en octubre. De esta forma, quienes perciban una remuneración bruta mensual de hasta $175.000 no se verán alcanzados por el tributo. La medida beneficia a más de 1.200.000 personas. La normativa también excluye del cálculo del impuesto al pago del Salario Anual Complementario que se abona en diciembre.  ', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `apellido` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `logon` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellido`, `email`, `logon`, `password`) VALUES
(1, 'Alejandro', 'Cancelos', 'alcancelos@gmail.com', 'admin', '1234'),
(3, 'Francisco', 'Rodriguez', 'francancelos@gmail.com', 'user', '1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `novedad`
--
ALTER TABLE `novedad`
  ADD PRIMARY KEY (`id_novedad`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `novedad`
--
ALTER TABLE `novedad`
  MODIFY `id_novedad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
