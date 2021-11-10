/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acceso.findAll", query = "SELECT a FROM Acceso a")
    , @NamedQuery(name = "Acceso.findByIdacceso", query = "SELECT a FROM Acceso a WHERE a.idacceso = :idacceso")
    , @NamedQuery(name = "Acceso.findByPermisoMenuClientes", query = "SELECT a FROM Acceso a WHERE a.permisoMenuClientes = :permisoMenuClientes")
    , @NamedQuery(name = "Acceso.findByPermisoMenuEmpleados", query = "SELECT a FROM Acceso a WHERE a.permisoMenuEmpleados = :permisoMenuEmpleados")
    , @NamedQuery(name = "Acceso.findByPermisoMenuVentas", query = "SELECT a FROM Acceso a WHERE a.permisoMenuVentas = :permisoMenuVentas")
    , @NamedQuery(name = "Acceso.findByPermisoMenuPedidos", query = "SELECT a FROM Acceso a WHERE a.permisoMenuPedidos = :permisoMenuPedidos")
    , @NamedQuery(name = "Acceso.findByPermisoMenuPiezas", query = "SELECT a FROM Acceso a WHERE a.permisoMenuPiezas = :permisoMenuPiezas")
    , @NamedQuery(name = "Acceso.findByPermisoMenuVehiculos", query = "SELECT a FROM Acceso a WHERE a.permisoMenuVehiculos = :permisoMenuVehiculos")
    , @NamedQuery(name = "Acceso.findByPermisoMenuBancos", query = "SELECT a FROM Acceso a WHERE a.permisoMenuBancos = :permisoMenuBancos")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionEmpleadosAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionEmpleadosAgregar = :permisoSeccionEmpleadosAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionEmpleadosModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionEmpleadosModificar = :permisoSeccionEmpleadosModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionEmpleadosDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionEmpleadosDesactivar = :permisoSeccionEmpleadosDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionEmpleadosBuscar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionEmpleadosBuscar = :permisoSeccionEmpleadosBuscar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionEmpleadosReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionEmpleadosReportePdf = :permisoSeccionEmpleadosReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionEmpleadosReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionEmpleadosReporteExcel = :permisoSeccionEmpleadosReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionCargosAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionCargosAgregar = :permisoSeccionCargosAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionCargosModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionCargosModificar = :permisoSeccionCargosModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionCargosDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionCargosDesactivar = :permisoSeccionCargosDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionCargosReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionCargosReportePdf = :permisoSeccionCargosReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionCargosReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionCargosReporteExcel = :permisoSeccionCargosReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionUsuariosAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionUsuariosAgregar = :permisoSeccionUsuariosAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionUsuariosModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionUsuariosModificar = :permisoSeccionUsuariosModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionUsuariosDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionUsuariosDesactivar = :permisoSeccionUsuariosDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionUsuariosBuscarUsuario", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionUsuariosBuscarUsuario = :permisoSeccionUsuariosBuscarUsuario")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionUsuariosBuscarEmpleado", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionUsuariosBuscarEmpleado = :permisoSeccionUsuariosBuscarEmpleado")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionUsuariosReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionUsuariosReportePdf = :permisoSeccionUsuariosReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionUsuariosReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionUsuariosReporteExcel = :permisoSeccionUsuariosReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionHistorialSueldosReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionHistorialSueldosReportePdf = :permisoSeccionHistorialSueldosReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionHistorialSueldosReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionHistorialSueldosReporteExcel = :permisoSeccionHistorialSueldosReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionHistorialCargosReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionHistorialCargosReportePdf = :permisoSeccionHistorialCargosReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionHistorialCargosReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionHistorialCargosReporteExcel = :permisoSeccionHistorialCargosReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionClientesAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionClientesAgregar = :permisoSeccionClientesAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionClientesModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionClientesModificar = :permisoSeccionClientesModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionClientesDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionClientesDesactivar = :permisoSeccionClientesDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionClientesBuscar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionClientesBuscar = :permisoSeccionClientesBuscar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionClientesReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionClientesReportePdf = :permisoSeccionClientesReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionClientesReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionClientesReporteExcel = :permisoSeccionClientesReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoDocumentoAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoDocumentoAgregar = :permisoSeccionTipoDocumentoAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoDocumentoModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoDocumentoModificar = :permisoSeccionTipoDocumentoModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoDocumentoDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoDocumentoDesactivar = :permisoSeccionTipoDocumentoDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoDocumentoReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoDocumentoReportePdf = :permisoSeccionTipoDocumentoReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoDocumentoReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoDocumentoReporteExcel = :permisoSeccionTipoDocumentoReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionBancosAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionBancosAgregar = :permisoSeccionBancosAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionBancosModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionBancosModificar = :permisoSeccionBancosModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionBancosDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionBancosDesactivar = :permisoSeccionBancosDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionBancosBuscar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionBancosBuscar = :permisoSeccionBancosBuscar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionBancosReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionBancosReportePdf = :permisoSeccionBancosReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionBancosReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionBancosReporteExcel = :permisoSeccionBancosReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPrestamosAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPrestamosAgregar = :permisoSeccionPrestamosAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPrestamosModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPrestamosModificar = :permisoSeccionPrestamosModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPrestamosDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPrestamosDesactivar = :permisoSeccionPrestamosDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPrestamosBuscarBanco", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPrestamosBuscarBanco = :permisoSeccionPrestamosBuscarBanco")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPrestamosBuscarCliente", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPrestamosBuscarCliente = :permisoSeccionPrestamosBuscarCliente")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPrestamosReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPrestamosReportePdf = :permisoSeccionPrestamosReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPrestamosReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPrestamosReporteExcel = :permisoSeccionPrestamosReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPedidosAgregarPieza", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPedidosAgregarPieza = :permisoSeccionPedidosAgregarPieza")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPedidosAgregarVehiculo", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPedidosAgregarVehiculo = :permisoSeccionPedidosAgregarVehiculo")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPedidosBuscarPieza", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPedidosBuscarPieza = :permisoSeccionPedidosBuscarPieza")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPedidosBuscarVehiculo", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPedidosBuscarVehiculo = :permisoSeccionPedidosBuscarVehiculo")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPedidosAgregarPedido", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPedidosAgregarPedido = :permisoSeccionPedidosAgregarPedido")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionListadoPedidosDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionListadoPedidosDesactivar = :permisoSeccionListadoPedidosDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionListadoPedidosReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionListadoPedidosReportePdf = :permisoSeccionListadoPedidosReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionListadoPedidosReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionListadoPedidosReporteExcel = :permisoSeccionListadoPedidosReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPiezasAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPiezasAgregar = :permisoSeccionPiezasAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPiezasModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPiezasModificar = :permisoSeccionPiezasModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPiezasDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPiezasDesactivar = :permisoSeccionPiezasDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPiezasReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPiezasReportePdf = :permisoSeccionPiezasReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionPiezasReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionPiezasReporteExcel = :permisoSeccionPiezasReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionHistorialPreciosPiezaBuscar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionHistorialPreciosPiezaBuscar = :permisoSeccionHistorialPreciosPiezaBuscar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionHistorialPreciosPiezaReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionHistorialPreciosPiezaReportePdf = :permisoSeccionHistorialPreciosPiezaReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionHistorialPreciosPiezaReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionHistorialPreciosPiezaReporteExcel = :permisoSeccionHistorialPreciosPiezaReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoPiezaAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoPiezaAgregar = :permisoSeccionTipoPiezaAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoPiezaModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoPiezaModificar = :permisoSeccionTipoPiezaModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoPiezaDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoPiezaDesactivar = :permisoSeccionTipoPiezaDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoPiezaReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoPiezaReportePdf = :permisoSeccionTipoPiezaReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoPiezaReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoPiezaReporteExcel = :permisoSeccionTipoPiezaReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionBuscarPiezaBuscar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionBuscarPiezaBuscar = :permisoSeccionBuscarPiezaBuscar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionBuscarPiezaReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionBuscarPiezaReportePdf = :permisoSeccionBuscarPiezaReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionBuscarPiezaReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionBuscarPiezaReporteExcel = :permisoSeccionBuscarPiezaReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionVehiculosAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionVehiculosAgregar = :permisoSeccionVehiculosAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionVehiculosModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionVehiculosModificar = :permisoSeccionVehiculosModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionVehiculosDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionVehiculosDesactivar = :permisoSeccionVehiculosDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionVehiculosReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionVehiculosReportePdf = :permisoSeccionVehiculosReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionVehiculosReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionVehiculosReporteExcel = :permisoSeccionVehiculosReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionHistorialPreciosVehiculoBuscar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionHistorialPreciosVehiculoBuscar = :permisoSeccionHistorialPreciosVehiculoBuscar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionHistorialPreciosVehiculoReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionHistorialPreciosVehiculoReportePdf = :permisoSeccionHistorialPreciosVehiculoReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionHistorialPreciosVehiculoReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionHistorialPreciosVehiculoReporteExcel = :permisoSeccionHistorialPreciosVehiculoReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionMarcaAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionMarcaAgregar = :permisoSeccionMarcaAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionMarcaModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionMarcaModificar = :permisoSeccionMarcaModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionMarcaDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionMarcaDesactivar = :permisoSeccionMarcaDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionMarcaReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionMarcaReportePdf = :permisoSeccionMarcaReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionMarcaReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionMarcaReporteExcel = :permisoSeccionMarcaReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionColorAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionColorAgregar = :permisoSeccionColorAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionColorModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionColorModificar = :permisoSeccionColorModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionColorDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionColorDesactivar = :permisoSeccionColorDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionColorReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionColorReportePdf = :permisoSeccionColorReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionColorReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionColorReporteExcel = :permisoSeccionColorReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoVehiculoAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoVehiculoAgregar = :permisoSeccionTipoVehiculoAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoVehiculoModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoVehiculoModificar = :permisoSeccionTipoVehiculoModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoVehiculoDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoVehiculoDesactivar = :permisoSeccionTipoVehiculoDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoVehiculoReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoVehiculoReportePdf = :permisoSeccionTipoVehiculoReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoVehiculoReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoVehiculoReporteExcel = :permisoSeccionTipoVehiculoReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoCabinaAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoCabinaAgregar = :permisoSeccionTipoCabinaAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoCabinaModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoCabinaModificar = :permisoSeccionTipoCabinaModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoCabinaDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoCabinaDesactivar = :permisoSeccionTipoCabinaDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoCabinaReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoCabinaReportePdf = :permisoSeccionTipoCabinaReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoCabinaReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoCabinaReporteExcel = :permisoSeccionTipoCabinaReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoCombustibleAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoCombustibleAgregar = :permisoSeccionTipoCombustibleAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoCombustibleModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoCombustibleModificar = :permisoSeccionTipoCombustibleModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoCombustibleDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoCombustibleDesactivar = :permisoSeccionTipoCombustibleDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoCombustibleReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoCombustibleReportePdf = :permisoSeccionTipoCombustibleReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoCombustibleReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoCombustibleReporteExcel = :permisoSeccionTipoCombustibleReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionNumeroAsientosAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionNumeroAsientosAgregar = :permisoSeccionNumeroAsientosAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionNumeroAsientosModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionNumeroAsientosModificar = :permisoSeccionNumeroAsientosModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionNumeroAsientosDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionNumeroAsientosDesactivar = :permisoSeccionNumeroAsientosDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionNumeroAsientosReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionNumeroAsientosReportePdf = :permisoSeccionNumeroAsientosReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionNumeroAsientosReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionNumeroAsientosReporteExcel = :permisoSeccionNumeroAsientosReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoTransmisionAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoTransmisionAgregar = :permisoSeccionTipoTransmisionAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoTransmisionModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoTransmisionModificar = :permisoSeccionTipoTransmisionModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoTransmisionDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoTransmisionDesactivar = :permisoSeccionTipoTransmisionDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoTransmisionReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoTransmisionReportePdf = :permisoSeccionTipoTransmisionReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoTransmisionReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoTransmisionReporteExcel = :permisoSeccionTipoTransmisionReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionBuscarVehiculoBuscar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionBuscarVehiculoBuscar = :permisoSeccionBuscarVehiculoBuscar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionBuscarVehiculoReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionBuscarVehiculoReportePdf = :permisoSeccionBuscarVehiculoReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionBuscarVehiculoExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionBuscarVehiculoExcel = :permisoSeccionBuscarVehiculoExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionReporteReportePdfTabla", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionReporteReportePdfTabla = :permisoSeccionReporteReportePdfTabla")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionReporteBuscar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionReporteBuscar = :permisoSeccionReporteBuscar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionVentasAgregarPieza", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionVentasAgregarPieza = :permisoSeccionVentasAgregarPieza")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionVentasAgregarVehiculo", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionVentasAgregarVehiculo = :permisoSeccionVentasAgregarVehiculo")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionVentasBuscarPieza", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionVentasBuscarPieza = :permisoSeccionVentasBuscarPieza")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionVentasBuscarVehiculo", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionVentasBuscarVehiculo = :permisoSeccionVentasBuscarVehiculo")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionVentasGenerarVenta", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionVentasGenerarVenta = :permisoSeccionVentasGenerarVenta")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoFacturaAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoFacturaAgregar = :permisoSeccionTipoFacturaAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoFacturaModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoFacturaModificar = :permisoSeccionTipoFacturaModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoFacturaDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoFacturaDesactivar = :permisoSeccionTipoFacturaDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoFacturaReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoFacturaReportePdf = :permisoSeccionTipoFacturaReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoFacturaReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoFacturaReporteExcel = :permisoSeccionTipoFacturaReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionCaiAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionCaiAgregar = :permisoSeccionCaiAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionCaiModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionCaiModificar = :permisoSeccionCaiModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionCaiDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionCaiDesactivar = :permisoSeccionCaiDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionCaiReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionCaiReportePdf = :permisoSeccionCaiReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionCaiReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionCaiReporteExcel = :permisoSeccionCaiReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoPagoAgregar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoPagoAgregar = :permisoSeccionTipoPagoAgregar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoPagoModificar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoPagoModificar = :permisoSeccionTipoPagoModificar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoPagoDesactivar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoPagoDesactivar = :permisoSeccionTipoPagoDesactivar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoPagoReportePdf", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoPagoReportePdf = :permisoSeccionTipoPagoReportePdf")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionTipoPagoReporteExcel", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionTipoPagoReporteExcel = :permisoSeccionTipoPagoReporteExcel")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionFacturasRechazadasBuscar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionFacturasRechazadasBuscar = :permisoSeccionFacturasRechazadasBuscar")
    , @NamedQuery(name = "Acceso.findByPermisoSeccionFacturasRechazadasRechazar", query = "SELECT a FROM Acceso a WHERE a.permisoSeccionFacturasRechazadasRechazar = :permisoSeccionFacturasRechazadasRechazar")})
public class Acceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_acceso")
    private Integer idacceso;
    @Column(name = "Id_usuario")
    private Integer idUsuario;
    @Column(name = "permiso_menu_clientes")
    private Boolean permisoMenuClientes;
    @Column(name = "permiso_menu_empleados")
    private Boolean permisoMenuEmpleados;
    @Column(name = "permiso_menu_ventas")
    private Boolean permisoMenuVentas;
    @Column(name = "permiso_menu_pedidos")
    private Boolean permisoMenuPedidos;
    @Column(name = "permiso_menu_piezas")
    private Boolean permisoMenuPiezas;
    @Column(name = "permiso_menu_vehiculos")
    private Boolean permisoMenuVehiculos;
    @Column(name = "permiso_menu_bancos")
    private Boolean permisoMenuBancos;
    @Column(name = "permiso_seccion_empleados_agregar")
    private Boolean permisoSeccionEmpleadosAgregar;
    @Column(name = "permiso_seccion_empleados_modificar")
    private Boolean permisoSeccionEmpleadosModificar;
    @Column(name = "permiso_seccion_empleados_desactivar")
    private Boolean permisoSeccionEmpleadosDesactivar;
    @Column(name = "permiso_seccion_empleados_buscar")
    private Boolean permisoSeccionEmpleadosBuscar;
    @Column(name = "permiso_seccion_empleados_reporte_pdf")
    private Boolean permisoSeccionEmpleadosReportePdf;
    @Column(name = "permiso_seccion_empleados_reporte_excel")
    private Boolean permisoSeccionEmpleadosReporteExcel;
    @Column(name = "permiso_seccion_cargos_agregar")
    private Boolean permisoSeccionCargosAgregar;
    @Column(name = "permiso_seccion_cargos_modificar")
    private Boolean permisoSeccionCargosModificar;
    @Column(name = "permiso_seccion_cargos_desactivar")
    private Boolean permisoSeccionCargosDesactivar;
    @Column(name = "permiso_seccion_cargos_reporte_pdf")
    private Boolean permisoSeccionCargosReportePdf;
    @Column(name = "permiso_seccion_cargos_reporte_excel")
    private Boolean permisoSeccionCargosReporteExcel;
    @Column(name = "permiso_seccion_usuarios_agregar")
    private Boolean permisoSeccionUsuariosAgregar;
    @Column(name = "permiso_seccion_usuarios_modificar")
    private Boolean permisoSeccionUsuariosModificar;
    @Column(name = "permiso_seccion_usuarios_desactivar")
    private Boolean permisoSeccionUsuariosDesactivar;
    @Column(name = "permiso_seccion_usuarios_buscar_usuario")
    private Boolean permisoSeccionUsuariosBuscarUsuario;
    @Column(name = "permiso_seccion_usuarios_buscar_empleado")
    private Boolean permisoSeccionUsuariosBuscarEmpleado;
    @Column(name = "permiso_seccion_usuarios_reporte_pdf")
    private Boolean permisoSeccionUsuariosReportePdf;
    @Column(name = "permiso_seccion_usuarios_reporte_excel")
    private Boolean permisoSeccionUsuariosReporteExcel;
    @Column(name = "permiso_seccion_historial_sueldos_reporte_pdf")
    private Boolean permisoSeccionHistorialSueldosReportePdf;
    @Column(name = "permiso_seccion_historial_sueldos_reporte_excel")
    private Boolean permisoSeccionHistorialSueldosReporteExcel;
    @Column(name = "permiso_seccion_historial_cargos_reporte_pdf")
    private Boolean permisoSeccionHistorialCargosReportePdf;
    @Column(name = "permiso_seccion_historial_cargos_reporte_excel")
    private Boolean permisoSeccionHistorialCargosReporteExcel;
    @Column(name = "permiso_seccion_clientes_agregar")
    private Boolean permisoSeccionClientesAgregar;
    @Column(name = "permiso_seccion_clientes_modificar")
    private Boolean permisoSeccionClientesModificar;
    @Column(name = "permiso_seccion_clientes_desactivar")
    private Boolean permisoSeccionClientesDesactivar;
    @Column(name = "permiso_seccion_clientes_buscar")
    private Boolean permisoSeccionClientesBuscar;
    @Column(name = "permiso_seccion_clientes_reporte_pdf")
    private Boolean permisoSeccionClientesReportePdf;
    @Column(name = "permiso_seccion_clientes_reporte_excel")
    private Boolean permisoSeccionClientesReporteExcel;
    @Column(name = "permiso_seccion_tipo_documento_agregar")
    private Boolean permisoSeccionTipoDocumentoAgregar;
    @Column(name = "permiso_seccion_tipo_documento_modificar")
    private Boolean permisoSeccionTipoDocumentoModificar;
    @Column(name = "permiso_seccion_tipo_documento_desactivar")
    private Boolean permisoSeccionTipoDocumentoDesactivar;
    @Column(name = "permiso_seccion_tipo_documento_reporte_pdf")
    private Boolean permisoSeccionTipoDocumentoReportePdf;
    @Column(name = "permiso_seccion_tipo_documento_reporte_excel")
    private Boolean permisoSeccionTipoDocumentoReporteExcel;
    @Column(name = "permiso_seccion_bancos_agregar")
    private Boolean permisoSeccionBancosAgregar;
    @Column(name = "permiso_seccion_bancos_modificar")
    private Boolean permisoSeccionBancosModificar;
    @Column(name = "permiso_seccion_bancos_desactivar")
    private Boolean permisoSeccionBancosDesactivar;
    @Column(name = "permiso_seccion_bancos_buscar")
    private Boolean permisoSeccionBancosBuscar;
    @Column(name = "permiso_seccion_bancos_reporte_pdf")
    private Boolean permisoSeccionBancosReportePdf;
    @Column(name = "permiso_seccion_bancos_reporte_excel")
    private Boolean permisoSeccionBancosReporteExcel;
    @Column(name = "permiso_seccion_prestamos_agregar")
    private Boolean permisoSeccionPrestamosAgregar;
    @Column(name = "permiso_seccion_prestamos_modificar")
    private Boolean permisoSeccionPrestamosModificar;
    @Column(name = "permiso_seccion_prestamos_desactivar")
    private Boolean permisoSeccionPrestamosDesactivar;
    @Column(name = "permiso_seccion_prestamos_buscar_banco")
    private Boolean permisoSeccionPrestamosBuscarBanco;
    @Column(name = "permiso_seccion_prestamos_buscar_cliente")
    private Boolean permisoSeccionPrestamosBuscarCliente;
    @Column(name = "permiso_seccion_prestamos_reporte_pdf")
    private Boolean permisoSeccionPrestamosReportePdf;
    @Column(name = "permiso_seccion_prestamos_reporte_excel")
    private Boolean permisoSeccionPrestamosReporteExcel;
    @Column(name = "permiso_seccion_pedidos_agregar_pieza")
    private Boolean permisoSeccionPedidosAgregarPieza;
    @Column(name = "permiso_seccion_pedidos_agregar_vehiculo")
    private Boolean permisoSeccionPedidosAgregarVehiculo;
    @Column(name = "permiso_seccion_pedidos_buscar_pieza")
    private Boolean permisoSeccionPedidosBuscarPieza;
    @Column(name = "permiso_seccion_pedidos_buscar_vehiculo")
    private Boolean permisoSeccionPedidosBuscarVehiculo;
    @Column(name = "permiso_seccion_pedidos_agregar_pedido")
    private Boolean permisoSeccionPedidosAgregarPedido;
    @Column(name = "permiso_seccion_listado_pedidos_desactivar")
    private Boolean permisoSeccionListadoPedidosDesactivar;
    @Column(name = "permiso_seccion_listado_pedidos_reporte_pdf")
    private Boolean permisoSeccionListadoPedidosReportePdf;
    @Column(name = "permiso_seccion_listado_pedidos_reporte_excel")
    private Boolean permisoSeccionListadoPedidosReporteExcel;
    @Column(name = "permiso_seccion_piezas_agregar")
    private Boolean permisoSeccionPiezasAgregar;
    @Column(name = "permiso_seccion_piezas_modificar")
    private Boolean permisoSeccionPiezasModificar;
    @Column(name = "permiso_seccion_piezas_desactivar")
    private Boolean permisoSeccionPiezasDesactivar;
    @Column(name = "permiso_seccion_piezas_reporte_pdf")
    private Boolean permisoSeccionPiezasReportePdf;
    @Column(name = "permiso_seccion_piezas_reporte_excel")
    private Boolean permisoSeccionPiezasReporteExcel;
    @Column(name = "permiso_seccion_historial_precios_pieza_buscar")
    private Boolean permisoSeccionHistorialPreciosPiezaBuscar;
    @Column(name = "permiso_seccion_historial_precios_pieza_reporte_pdf")
    private Boolean permisoSeccionHistorialPreciosPiezaReportePdf;
    @Column(name = "permiso_seccion_historial_precios_pieza_reporte_excel")
    private Boolean permisoSeccionHistorialPreciosPiezaReporteExcel;
    @Column(name = "permiso_seccion_tipo_pieza_agregar")
    private Boolean permisoSeccionTipoPiezaAgregar;
    @Column(name = "permiso_seccion_tipo_pieza_modificar")
    private Boolean permisoSeccionTipoPiezaModificar;
    @Column(name = "permiso_seccion_tipo_pieza_desactivar")
    private Boolean permisoSeccionTipoPiezaDesactivar;
    @Column(name = "permiso_seccion_tipo_pieza_reporte_pdf")
    private Boolean permisoSeccionTipoPiezaReportePdf;
    @Column(name = "permiso_seccion_tipo_pieza_reporte_excel")
    private Boolean permisoSeccionTipoPiezaReporteExcel;
    @Column(name = "permiso_seccion_buscar_pieza_buscar")
    private Boolean permisoSeccionBuscarPiezaBuscar;
    @Column(name = "permiso_seccion_buscar_pieza_reporte_pdf")
    private Boolean permisoSeccionBuscarPiezaReportePdf;
    @Column(name = "permiso_seccion_buscar_pieza_reporte_excel")
    private Boolean permisoSeccionBuscarPiezaReporteExcel;
    @Column(name = "permiso_seccion_vehiculos_agregar")
    private Boolean permisoSeccionVehiculosAgregar;
    @Column(name = "permiso_seccion_vehiculos_modificar")
    private Boolean permisoSeccionVehiculosModificar;
    @Column(name = "permiso_seccion_vehiculos_desactivar")
    private Boolean permisoSeccionVehiculosDesactivar;
    @Column(name = "permiso_seccion_vehiculos_reporte_pdf")
    private Boolean permisoSeccionVehiculosReportePdf;
    @Column(name = "permiso_seccion_vehiculos_reporte_excel")
    private Boolean permisoSeccionVehiculosReporteExcel;
    @Column(name = "permiso_seccion_historial_precios_vehiculo_buscar")
    private Boolean permisoSeccionHistorialPreciosVehiculoBuscar;
    @Column(name = "permiso_seccion_historial_precios_vehiculo_reporte_pdf")
    private Boolean permisoSeccionHistorialPreciosVehiculoReportePdf;
    @Column(name = "permiso_seccion_historial_precios_vehiculo_reporte_excel")
    private Boolean permisoSeccionHistorialPreciosVehiculoReporteExcel;
    @Column(name = "permiso_seccion_marca_agregar")
    private Boolean permisoSeccionMarcaAgregar;
    @Column(name = "permiso_seccion_marca_modificar")
    private Boolean permisoSeccionMarcaModificar;
    @Column(name = "permiso_seccion_marca_desactivar")
    private Boolean permisoSeccionMarcaDesactivar;
    @Column(name = "permiso_seccion_marca_reporte_pdf")
    private Boolean permisoSeccionMarcaReportePdf;
    @Column(name = "permiso_seccion_marca_reporte_excel")
    private Boolean permisoSeccionMarcaReporteExcel;
    @Column(name = "permiso_seccion_color_agregar")
    private Boolean permisoSeccionColorAgregar;
    @Column(name = "permiso_seccion_color_modificar")
    private Boolean permisoSeccionColorModificar;
    @Column(name = "permiso_seccion_color_desactivar")
    private Boolean permisoSeccionColorDesactivar;
    @Column(name = "permiso_seccion_color_reporte_pdf")
    private Boolean permisoSeccionColorReportePdf;
    @Column(name = "permiso_seccion_color_reporte_excel")
    private Boolean permisoSeccionColorReporteExcel;
    @Column(name = "permiso_seccion_tipo_vehiculo_agregar")
    private Boolean permisoSeccionTipoVehiculoAgregar;
    @Column(name = "permiso_seccion_tipo_vehiculo_modificar")
    private Boolean permisoSeccionTipoVehiculoModificar;
    @Column(name = "permiso_seccion_tipo_vehiculo_desactivar")
    private Boolean permisoSeccionTipoVehiculoDesactivar;
    @Column(name = "permiso_seccion_tipo_vehiculo_reporte_pdf")
    private Boolean permisoSeccionTipoVehiculoReportePdf;
    @Column(name = "permiso_seccion_tipo_vehiculo_reporte_excel")
    private Boolean permisoSeccionTipoVehiculoReporteExcel;
    @Column(name = "permiso_seccion_tipo_cabina_agregar")
    private Boolean permisoSeccionTipoCabinaAgregar;
    @Column(name = "permiso_seccion_tipo_cabina_modificar")
    private Boolean permisoSeccionTipoCabinaModificar;
    @Column(name = "permiso_seccion_tipo_cabina_desactivar")
    private Boolean permisoSeccionTipoCabinaDesactivar;
    @Column(name = "permiso_seccion_tipo_cabina_reporte_pdf")
    private Boolean permisoSeccionTipoCabinaReportePdf;
    @Column(name = "permiso_seccion_tipo_cabina_reporte_excel")
    private Boolean permisoSeccionTipoCabinaReporteExcel;
    @Column(name = "permiso_seccion_tipo_combustible_agregar")
    private Boolean permisoSeccionTipoCombustibleAgregar;
    @Column(name = "permiso_seccion_tipo_combustible_modificar")
    private Boolean permisoSeccionTipoCombustibleModificar;
    @Column(name = "permiso_seccion_tipo_combustible_desactivar")
    private Boolean permisoSeccionTipoCombustibleDesactivar;
    @Column(name = "permiso_seccion_tipo_combustible_reporte_pdf")
    private Boolean permisoSeccionTipoCombustibleReportePdf;
    @Column(name = "permiso_seccion_tipo_combustible_reporte_excel")
    private Boolean permisoSeccionTipoCombustibleReporteExcel;
    @Column(name = "permiso_seccion_numero_asientos_agregar")
    private Boolean permisoSeccionNumeroAsientosAgregar;
    @Column(name = "permiso_seccion_numero_asientos_modificar")
    private Boolean permisoSeccionNumeroAsientosModificar;
    @Column(name = "permiso_seccion_numero_asientos_desactivar")
    private Boolean permisoSeccionNumeroAsientosDesactivar;
    @Column(name = "permiso_seccion_numero_asientos_reporte_pdf")
    private Boolean permisoSeccionNumeroAsientosReportePdf;
    @Column(name = "permiso_seccion_numero_asientos_reporte_excel")
    private Boolean permisoSeccionNumeroAsientosReporteExcel;
    @Column(name = "permiso_seccion_tipo_transmision_agregar")
    private Boolean permisoSeccionTipoTransmisionAgregar;
    @Column(name = "permiso_seccion_tipo_transmision_modificar")
    private Boolean permisoSeccionTipoTransmisionModificar;
    @Column(name = "permiso_seccion_tipo_transmision_desactivar")
    private Boolean permisoSeccionTipoTransmisionDesactivar;
    @Column(name = "permiso_seccion_tipo_transmision_reporte_pdf")
    private Boolean permisoSeccionTipoTransmisionReportePdf;
    @Column(name = "permiso_seccion_tipo_transmision_reporte_excel")
    private Boolean permisoSeccionTipoTransmisionReporteExcel;
    @Column(name = "permiso_seccion_buscar_vehiculo_buscar")
    private Boolean permisoSeccionBuscarVehiculoBuscar;
    @Column(name = "permiso_seccion_buscar_vehiculo_reporte_pdf")
    private Boolean permisoSeccionBuscarVehiculoReportePdf;
    @Column(name = "permiso_seccion_buscar_vehiculo_excel")
    private Boolean permisoSeccionBuscarVehiculoExcel;
    @Column(name = "permiso_seccion_reporte_reporte_pdf_tabla")
    private Boolean permisoSeccionReporteReportePdfTabla;
    @Column(name = "permiso_seccion_reporte_buscar")
    private Boolean permisoSeccionReporteBuscar;
    @Column(name = "permiso_seccion_ventas_agregar_pieza")
    private Boolean permisoSeccionVentasAgregarPieza;
    @Column(name = "permiso_seccion_ventas_agregar_vehiculo")
    private Boolean permisoSeccionVentasAgregarVehiculo;
    @Column(name = "permiso_seccion_ventas_buscar_pieza")
    private Boolean permisoSeccionVentasBuscarPieza;
    @Column(name = "permiso_seccion_ventas_buscar_vehiculo")
    private Boolean permisoSeccionVentasBuscarVehiculo;
    @Column(name = "permiso_seccion_ventas_generar_venta")
    private Boolean permisoSeccionVentasGenerarVenta;
    @Column(name = "permiso_seccion_tipo_factura_agregar")
    private Boolean permisoSeccionTipoFacturaAgregar;
    @Column(name = "permiso_seccion_tipo_factura_modificar")
    private Boolean permisoSeccionTipoFacturaModificar;
    @Column(name = "permiso_seccion_tipo_factura_desactivar")
    private Boolean permisoSeccionTipoFacturaDesactivar;
    @Column(name = "permiso_seccion_tipo_factura_reporte_pdf")
    private Boolean permisoSeccionTipoFacturaReportePdf;
    @Column(name = "permiso_seccion_tipo_factura_reporte_excel")
    private Boolean permisoSeccionTipoFacturaReporteExcel;
    @Column(name = "permiso_seccion_cai_agregar")
    private Boolean permisoSeccionCaiAgregar;
    @Column(name = "permiso_seccion_cai_modificar")
    private Boolean permisoSeccionCaiModificar;
    @Column(name = "permiso_seccion_cai_desactivar")
    private Boolean permisoSeccionCaiDesactivar;
    @Column(name = "permiso_seccion_cai_reporte_pdf")
    private Boolean permisoSeccionCaiReportePdf;
    @Column(name = "permiso_seccion_cai_reporte_excel")
    private Boolean permisoSeccionCaiReporteExcel;
    @Column(name = "permiso_seccion_tipo_pago_agregar")
    private Boolean permisoSeccionTipoPagoAgregar;
    @Column(name = "permiso_seccion_tipo_pago_modificar")
    private Boolean permisoSeccionTipoPagoModificar;
    @Column(name = "permiso_seccion_tipo_pago_desactivar")
    private Boolean permisoSeccionTipoPagoDesactivar;
    @Column(name = "permiso_seccion_tipo_pago_reporte_pdf")
    private Boolean permisoSeccionTipoPagoReportePdf;
    @Column(name = "permiso_seccion_tipo_pago_reporte_excel")
    private Boolean permisoSeccionTipoPagoReporteExcel;
    @Column(name = "permiso_seccion_facturas_rechazadas_buscar")
    private Boolean permisoSeccionFacturasRechazadasBuscar;
    @Column(name = "permiso_seccion_facturas_rechazadas_rechazar")
    private Boolean permisoSeccionFacturasRechazadasRechazar;

    public Acceso() {
    }

    public Acceso(Integer idacceso) {
        this.idacceso = idacceso;
    }

    public Integer getIdacceso() {
        return idacceso;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    
    public void setIdacceso(Integer idacceso) {
        this.idacceso = idacceso;
    }

    public Boolean getPermisoMenuClientes() {
        return permisoMenuClientes;
    }

    public void setPermisoMenuClientes(Boolean permisoMenuClientes) {
        this.permisoMenuClientes = permisoMenuClientes;
    }

    public Boolean getPermisoMenuEmpleados() {
        return permisoMenuEmpleados;
    }

    public void setPermisoMenuEmpleados(Boolean permisoMenuEmpleados) {
        this.permisoMenuEmpleados = permisoMenuEmpleados;
    }

    public Boolean getPermisoMenuVentas() {
        return permisoMenuVentas;
    }

    public void setPermisoMenuVentas(Boolean permisoMenuVentas) {
        this.permisoMenuVentas = permisoMenuVentas;
    }

    public Boolean getPermisoMenuPedidos() {
        return permisoMenuPedidos;
    }

    public void setPermisoMenuPedidos(Boolean permisoMenuPedidos) {
        this.permisoMenuPedidos = permisoMenuPedidos;
    }

    public Boolean getPermisoMenuPiezas() {
        return permisoMenuPiezas;
    }

    public void setPermisoMenuPiezas(Boolean permisoMenuPiezas) {
        this.permisoMenuPiezas = permisoMenuPiezas;
    }

    public Boolean getPermisoMenuVehiculos() {
        return permisoMenuVehiculos;
    }

    public void setPermisoMenuVehiculos(Boolean permisoMenuVehiculos) {
        this.permisoMenuVehiculos = permisoMenuVehiculos;
    }

    public Boolean getPermisoMenuBancos() {
        return permisoMenuBancos;
    }

    public void setPermisoMenuBancos(Boolean permisoMenuBancos) {
        this.permisoMenuBancos = permisoMenuBancos;
    }

    public Boolean getPermisoSeccionEmpleadosAgregar() {
        return permisoSeccionEmpleadosAgregar;
    }

    public void setPermisoSeccionEmpleadosAgregar(Boolean permisoSeccionEmpleadosAgregar) {
        this.permisoSeccionEmpleadosAgregar = permisoSeccionEmpleadosAgregar;
    }

    public Boolean getPermisoSeccionEmpleadosModificar() {
        return permisoSeccionEmpleadosModificar;
    }

    public void setPermisoSeccionEmpleadosModificar(Boolean permisoSeccionEmpleadosModificar) {
        this.permisoSeccionEmpleadosModificar = permisoSeccionEmpleadosModificar;
    }

    public Boolean getPermisoSeccionEmpleadosDesactivar() {
        return permisoSeccionEmpleadosDesactivar;
    }

    public void setPermisoSeccionEmpleadosDesactivar(Boolean permisoSeccionEmpleadosDesactivar) {
        this.permisoSeccionEmpleadosDesactivar = permisoSeccionEmpleadosDesactivar;
    }

    public Boolean getPermisoSeccionEmpleadosBuscar() {
        return permisoSeccionEmpleadosBuscar;
    }

    public void setPermisoSeccionEmpleadosBuscar(Boolean permisoSeccionEmpleadosBuscar) {
        this.permisoSeccionEmpleadosBuscar = permisoSeccionEmpleadosBuscar;
    }

    public Boolean getPermisoSeccionEmpleadosReportePdf() {
        return permisoSeccionEmpleadosReportePdf;
    }

    public void setPermisoSeccionEmpleadosReportePdf(Boolean permisoSeccionEmpleadosReportePdf) {
        this.permisoSeccionEmpleadosReportePdf = permisoSeccionEmpleadosReportePdf;
    }

    public Boolean getPermisoSeccionEmpleadosReporteExcel() {
        return permisoSeccionEmpleadosReporteExcel;
    }

    public void setPermisoSeccionEmpleadosReporteExcel(Boolean permisoSeccionEmpleadosReporteExcel) {
        this.permisoSeccionEmpleadosReporteExcel = permisoSeccionEmpleadosReporteExcel;
    }

    public Boolean getPermisoSeccionCargosAgregar() {
        return permisoSeccionCargosAgregar;
    }

    public void setPermisoSeccionCargosAgregar(Boolean permisoSeccionCargosAgregar) {
        this.permisoSeccionCargosAgregar = permisoSeccionCargosAgregar;
    }

    public Boolean getPermisoSeccionCargosModificar() {
        return permisoSeccionCargosModificar;
    }

    public void setPermisoSeccionCargosModificar(Boolean permisoSeccionCargosModificar) {
        this.permisoSeccionCargosModificar = permisoSeccionCargosModificar;
    }

    public Boolean getPermisoSeccionCargosDesactivar() {
        return permisoSeccionCargosDesactivar;
    }

    public void setPermisoSeccionCargosDesactivar(Boolean permisoSeccionCargosDesactivar) {
        this.permisoSeccionCargosDesactivar = permisoSeccionCargosDesactivar;
    }

    public Boolean getPermisoSeccionCargosReportePdf() {
        return permisoSeccionCargosReportePdf;
    }

    public void setPermisoSeccionCargosReportePdf(Boolean permisoSeccionCargosReportePdf) {
        this.permisoSeccionCargosReportePdf = permisoSeccionCargosReportePdf;
    }

    public Boolean getPermisoSeccionCargosReporteExcel() {
        return permisoSeccionCargosReporteExcel;
    }

    public void setPermisoSeccionCargosReporteExcel(Boolean permisoSeccionCargosReporteExcel) {
        this.permisoSeccionCargosReporteExcel = permisoSeccionCargosReporteExcel;
    }

    public Boolean getPermisoSeccionUsuariosAgregar() {
        return permisoSeccionUsuariosAgregar;
    }

    public void setPermisoSeccionUsuariosAgregar(Boolean permisoSeccionUsuariosAgregar) {
        this.permisoSeccionUsuariosAgregar = permisoSeccionUsuariosAgregar;
    }

    public Boolean getPermisoSeccionUsuariosModificar() {
        return permisoSeccionUsuariosModificar;
    }

    public void setPermisoSeccionUsuariosModificar(Boolean permisoSeccionUsuariosModificar) {
        this.permisoSeccionUsuariosModificar = permisoSeccionUsuariosModificar;
    }

    public Boolean getPermisoSeccionUsuariosDesactivar() {
        return permisoSeccionUsuariosDesactivar;
    }

    public void setPermisoSeccionUsuariosDesactivar(Boolean permisoSeccionUsuariosDesactivar) {
        this.permisoSeccionUsuariosDesactivar = permisoSeccionUsuariosDesactivar;
    }

    public Boolean getPermisoSeccionUsuariosBuscarUsuario() {
        return permisoSeccionUsuariosBuscarUsuario;
    }

    public void setPermisoSeccionUsuariosBuscarUsuario(Boolean permisoSeccionUsuariosBuscarUsuario) {
        this.permisoSeccionUsuariosBuscarUsuario = permisoSeccionUsuariosBuscarUsuario;
    }

    public Boolean getPermisoSeccionUsuariosBuscarEmpleado() {
        return permisoSeccionUsuariosBuscarEmpleado;
    }

    public void setPermisoSeccionUsuariosBuscarEmpleado(Boolean permisoSeccionUsuariosBuscarEmpleado) {
        this.permisoSeccionUsuariosBuscarEmpleado = permisoSeccionUsuariosBuscarEmpleado;
    }

    public Boolean getPermisoSeccionUsuariosReportePdf() {
        return permisoSeccionUsuariosReportePdf;
    }

    public void setPermisoSeccionUsuariosReportePdf(Boolean permisoSeccionUsuariosReportePdf) {
        this.permisoSeccionUsuariosReportePdf = permisoSeccionUsuariosReportePdf;
    }

    public Boolean getPermisoSeccionUsuariosReporteExcel() {
        return permisoSeccionUsuariosReporteExcel;
    }

    public void setPermisoSeccionUsuariosReporteExcel(Boolean permisoSeccionUsuariosReporteExcel) {
        this.permisoSeccionUsuariosReporteExcel = permisoSeccionUsuariosReporteExcel;
    }

    public Boolean getPermisoSeccionHistorialSueldosReportePdf() {
        return permisoSeccionHistorialSueldosReportePdf;
    }

    public void setPermisoSeccionHistorialSueldosReportePdf(Boolean permisoSeccionHistorialSueldosReportePdf) {
        this.permisoSeccionHistorialSueldosReportePdf = permisoSeccionHistorialSueldosReportePdf;
    }

    public Boolean getPermisoSeccionHistorialSueldosReporteExcel() {
        return permisoSeccionHistorialSueldosReporteExcel;
    }

    public void setPermisoSeccionHistorialSueldosReporteExcel(Boolean permisoSeccionHistorialSueldosReporteExcel) {
        this.permisoSeccionHistorialSueldosReporteExcel = permisoSeccionHistorialSueldosReporteExcel;
    }

    public Boolean getPermisoSeccionHistorialCargosReportePdf() {
        return permisoSeccionHistorialCargosReportePdf;
    }

    public void setPermisoSeccionHistorialCargosReportePdf(Boolean permisoSeccionHistorialCargosReportePdf) {
        this.permisoSeccionHistorialCargosReportePdf = permisoSeccionHistorialCargosReportePdf;
    }

    public Boolean getPermisoSeccionHistorialCargosReporteExcel() {
        return permisoSeccionHistorialCargosReporteExcel;
    }

    public void setPermisoSeccionHistorialCargosReporteExcel(Boolean permisoSeccionHistorialCargosReporteExcel) {
        this.permisoSeccionHistorialCargosReporteExcel = permisoSeccionHistorialCargosReporteExcel;
    }

    public Boolean getPermisoSeccionClientesAgregar() {
        return permisoSeccionClientesAgregar;
    }

    public void setPermisoSeccionClientesAgregar(Boolean permisoSeccionClientesAgregar) {
        this.permisoSeccionClientesAgregar = permisoSeccionClientesAgregar;
    }

    public Boolean getPermisoSeccionClientesModificar() {
        return permisoSeccionClientesModificar;
    }

    public void setPermisoSeccionClientesModificar(Boolean permisoSeccionClientesModificar) {
        this.permisoSeccionClientesModificar = permisoSeccionClientesModificar;
    }

    public Boolean getPermisoSeccionClientesDesactivar() {
        return permisoSeccionClientesDesactivar;
    }

    public void setPermisoSeccionClientesDesactivar(Boolean permisoSeccionClientesDesactivar) {
        this.permisoSeccionClientesDesactivar = permisoSeccionClientesDesactivar;
    }

    public Boolean getPermisoSeccionClientesBuscar() {
        return permisoSeccionClientesBuscar;
    }

    public void setPermisoSeccionClientesBuscar(Boolean permisoSeccionClientesBuscar) {
        this.permisoSeccionClientesBuscar = permisoSeccionClientesBuscar;
    }

    public Boolean getPermisoSeccionClientesReportePdf() {
        return permisoSeccionClientesReportePdf;
    }

    public void setPermisoSeccionClientesReportePdf(Boolean permisoSeccionClientesReportePdf) {
        this.permisoSeccionClientesReportePdf = permisoSeccionClientesReportePdf;
    }

    public Boolean getPermisoSeccionClientesReporteExcel() {
        return permisoSeccionClientesReporteExcel;
    }

    public void setPermisoSeccionClientesReporteExcel(Boolean permisoSeccionClientesReporteExcel) {
        this.permisoSeccionClientesReporteExcel = permisoSeccionClientesReporteExcel;
    }

    public Boolean getPermisoSeccionTipoDocumentoAgregar() {
        return permisoSeccionTipoDocumentoAgregar;
    }

    public void setPermisoSeccionTipoDocumentoAgregar(Boolean permisoSeccionTipoDocumentoAgregar) {
        this.permisoSeccionTipoDocumentoAgregar = permisoSeccionTipoDocumentoAgregar;
    }

    public Boolean getPermisoSeccionTipoDocumentoModificar() {
        return permisoSeccionTipoDocumentoModificar;
    }

    public void setPermisoSeccionTipoDocumentoModificar(Boolean permisoSeccionTipoDocumentoModificar) {
        this.permisoSeccionTipoDocumentoModificar = permisoSeccionTipoDocumentoModificar;
    }

    public Boolean getPermisoSeccionTipoDocumentoDesactivar() {
        return permisoSeccionTipoDocumentoDesactivar;
    }

    public void setPermisoSeccionTipoDocumentoDesactivar(Boolean permisoSeccionTipoDocumentoDesactivar) {
        this.permisoSeccionTipoDocumentoDesactivar = permisoSeccionTipoDocumentoDesactivar;
    }

    public Boolean getPermisoSeccionTipoDocumentoReportePdf() {
        return permisoSeccionTipoDocumentoReportePdf;
    }

    public void setPermisoSeccionTipoDocumentoReportePdf(Boolean permisoSeccionTipoDocumentoReportePdf) {
        this.permisoSeccionTipoDocumentoReportePdf = permisoSeccionTipoDocumentoReportePdf;
    }

    public Boolean getPermisoSeccionTipoDocumentoReporteExcel() {
        return permisoSeccionTipoDocumentoReporteExcel;
    }

    public void setPermisoSeccionTipoDocumentoReporteExcel(Boolean permisoSeccionTipoDocumentoReporteExcel) {
        this.permisoSeccionTipoDocumentoReporteExcel = permisoSeccionTipoDocumentoReporteExcel;
    }

    public Boolean getPermisoSeccionBancosAgregar() {
        return permisoSeccionBancosAgregar;
    }

    public void setPermisoSeccionBancosAgregar(Boolean permisoSeccionBancosAgregar) {
        this.permisoSeccionBancosAgregar = permisoSeccionBancosAgregar;
    }

    public Boolean getPermisoSeccionBancosModificar() {
        return permisoSeccionBancosModificar;
    }

    public void setPermisoSeccionBancosModificar(Boolean permisoSeccionBancosModificar) {
        this.permisoSeccionBancosModificar = permisoSeccionBancosModificar;
    }

    public Boolean getPermisoSeccionBancosDesactivar() {
        return permisoSeccionBancosDesactivar;
    }

    public void setPermisoSeccionBancosDesactivar(Boolean permisoSeccionBancosDesactivar) {
        this.permisoSeccionBancosDesactivar = permisoSeccionBancosDesactivar;
    }

    public Boolean getPermisoSeccionBancosBuscar() {
        return permisoSeccionBancosBuscar;
    }

    public void setPermisoSeccionBancosBuscar(Boolean permisoSeccionBancosBuscar) {
        this.permisoSeccionBancosBuscar = permisoSeccionBancosBuscar;
    }

    public Boolean getPermisoSeccionBancosReportePdf() {
        return permisoSeccionBancosReportePdf;
    }

    public void setPermisoSeccionBancosReportePdf(Boolean permisoSeccionBancosReportePdf) {
        this.permisoSeccionBancosReportePdf = permisoSeccionBancosReportePdf;
    }

    public Boolean getPermisoSeccionBancosReporteExcel() {
        return permisoSeccionBancosReporteExcel;
    }

    public void setPermisoSeccionBancosReporteExcel(Boolean permisoSeccionBancosReporteExcel) {
        this.permisoSeccionBancosReporteExcel = permisoSeccionBancosReporteExcel;
    }

    public Boolean getPermisoSeccionPrestamosAgregar() {
        return permisoSeccionPrestamosAgregar;
    }

    public void setPermisoSeccionPrestamosAgregar(Boolean permisoSeccionPrestamosAgregar) {
        this.permisoSeccionPrestamosAgregar = permisoSeccionPrestamosAgregar;
    }

    public Boolean getPermisoSeccionPrestamosModificar() {
        return permisoSeccionPrestamosModificar;
    }

    public void setPermisoSeccionPrestamosModificar(Boolean permisoSeccionPrestamosModificar) {
        this.permisoSeccionPrestamosModificar = permisoSeccionPrestamosModificar;
    }

    public Boolean getPermisoSeccionPrestamosDesactivar() {
        return permisoSeccionPrestamosDesactivar;
    }

    public void setPermisoSeccionPrestamosDesactivar(Boolean permisoSeccionPrestamosDesactivar) {
        this.permisoSeccionPrestamosDesactivar = permisoSeccionPrestamosDesactivar;
    }

    public Boolean getPermisoSeccionPrestamosBuscarBanco() {
        return permisoSeccionPrestamosBuscarBanco;
    }

    public void setPermisoSeccionPrestamosBuscarBanco(Boolean permisoSeccionPrestamosBuscarBanco) {
        this.permisoSeccionPrestamosBuscarBanco = permisoSeccionPrestamosBuscarBanco;
    }

    public Boolean getPermisoSeccionPrestamosBuscarCliente() {
        return permisoSeccionPrestamosBuscarCliente;
    }

    public void setPermisoSeccionPrestamosBuscarCliente(Boolean permisoSeccionPrestamosBuscarCliente) {
        this.permisoSeccionPrestamosBuscarCliente = permisoSeccionPrestamosBuscarCliente;
    }

    public Boolean getPermisoSeccionPrestamosReportePdf() {
        return permisoSeccionPrestamosReportePdf;
    }

    public void setPermisoSeccionPrestamosReportePdf(Boolean permisoSeccionPrestamosReportePdf) {
        this.permisoSeccionPrestamosReportePdf = permisoSeccionPrestamosReportePdf;
    }

    public Boolean getPermisoSeccionPrestamosReporteExcel() {
        return permisoSeccionPrestamosReporteExcel;
    }

    public void setPermisoSeccionPrestamosReporteExcel(Boolean permisoSeccionPrestamosReporteExcel) {
        this.permisoSeccionPrestamosReporteExcel = permisoSeccionPrestamosReporteExcel;
    }

    public Boolean getPermisoSeccionPedidosAgregarPieza() {
        return permisoSeccionPedidosAgregarPieza;
    }

    public void setPermisoSeccionPedidosAgregarPieza(Boolean permisoSeccionPedidosAgregarPieza) {
        this.permisoSeccionPedidosAgregarPieza = permisoSeccionPedidosAgregarPieza;
    }

    public Boolean getPermisoSeccionPedidosAgregarVehiculo() {
        return permisoSeccionPedidosAgregarVehiculo;
    }

    public void setPermisoSeccionPedidosAgregarVehiculo(Boolean permisoSeccionPedidosAgregarVehiculo) {
        this.permisoSeccionPedidosAgregarVehiculo = permisoSeccionPedidosAgregarVehiculo;
    }

    public Boolean getPermisoSeccionPedidosBuscarPieza() {
        return permisoSeccionPedidosBuscarPieza;
    }

    public void setPermisoSeccionPedidosBuscarPieza(Boolean permisoSeccionPedidosBuscarPieza) {
        this.permisoSeccionPedidosBuscarPieza = permisoSeccionPedidosBuscarPieza;
    }

    public Boolean getPermisoSeccionPedidosBuscarVehiculo() {
        return permisoSeccionPedidosBuscarVehiculo;
    }

    public void setPermisoSeccionPedidosBuscarVehiculo(Boolean permisoSeccionPedidosBuscarVehiculo) {
        this.permisoSeccionPedidosBuscarVehiculo = permisoSeccionPedidosBuscarVehiculo;
    }

    public Boolean getPermisoSeccionPedidosAgregarPedido() {
        return permisoSeccionPedidosAgregarPedido;
    }

    public void setPermisoSeccionPedidosAgregarPedido(Boolean permisoSeccionPedidosAgregarPedido) {
        this.permisoSeccionPedidosAgregarPedido = permisoSeccionPedidosAgregarPedido;
    }

    public Boolean getPermisoSeccionListadoPedidosDesactivar() {
        return permisoSeccionListadoPedidosDesactivar;
    }

    public void setPermisoSeccionListadoPedidosDesactivar(Boolean permisoSeccionListadoPedidosDesactivar) {
        this.permisoSeccionListadoPedidosDesactivar = permisoSeccionListadoPedidosDesactivar;
    }

    public Boolean getPermisoSeccionListadoPedidosReportePdf() {
        return permisoSeccionListadoPedidosReportePdf;
    }

    public void setPermisoSeccionListadoPedidosReportePdf(Boolean permisoSeccionListadoPedidosReportePdf) {
        this.permisoSeccionListadoPedidosReportePdf = permisoSeccionListadoPedidosReportePdf;
    }

    public Boolean getPermisoSeccionListadoPedidosReporteExcel() {
        return permisoSeccionListadoPedidosReporteExcel;
    }

    public void setPermisoSeccionListadoPedidosReporteExcel(Boolean permisoSeccionListadoPedidosReporteExcel) {
        this.permisoSeccionListadoPedidosReporteExcel = permisoSeccionListadoPedidosReporteExcel;
    }

    public Boolean getPermisoSeccionPiezasAgregar() {
        return permisoSeccionPiezasAgregar;
    }

    public void setPermisoSeccionPiezasAgregar(Boolean permisoSeccionPiezasAgregar) {
        this.permisoSeccionPiezasAgregar = permisoSeccionPiezasAgregar;
    }

    public Boolean getPermisoSeccionPiezasModificar() {
        return permisoSeccionPiezasModificar;
    }

    public void setPermisoSeccionPiezasModificar(Boolean permisoSeccionPiezasModificar) {
        this.permisoSeccionPiezasModificar = permisoSeccionPiezasModificar;
    }

    public Boolean getPermisoSeccionPiezasDesactivar() {
        return permisoSeccionPiezasDesactivar;
    }

    public void setPermisoSeccionPiezasDesactivar(Boolean permisoSeccionPiezasDesactivar) {
        this.permisoSeccionPiezasDesactivar = permisoSeccionPiezasDesactivar;
    }

    public Boolean getPermisoSeccionPiezasReportePdf() {
        return permisoSeccionPiezasReportePdf;
    }

    public void setPermisoSeccionPiezasReportePdf(Boolean permisoSeccionPiezasReportePdf) {
        this.permisoSeccionPiezasReportePdf = permisoSeccionPiezasReportePdf;
    }

    public Boolean getPermisoSeccionPiezasReporteExcel() {
        return permisoSeccionPiezasReporteExcel;
    }

    public void setPermisoSeccionPiezasReporteExcel(Boolean permisoSeccionPiezasReporteExcel) {
        this.permisoSeccionPiezasReporteExcel = permisoSeccionPiezasReporteExcel;
    }

    public Boolean getPermisoSeccionHistorialPreciosPiezaBuscar() {
        return permisoSeccionHistorialPreciosPiezaBuscar;
    }

    public void setPermisoSeccionHistorialPreciosPiezaBuscar(Boolean permisoSeccionHistorialPreciosPiezaBuscar) {
        this.permisoSeccionHistorialPreciosPiezaBuscar = permisoSeccionHistorialPreciosPiezaBuscar;
    }

    public Boolean getPermisoSeccionHistorialPreciosPiezaReportePdf() {
        return permisoSeccionHistorialPreciosPiezaReportePdf;
    }

    public void setPermisoSeccionHistorialPreciosPiezaReportePdf(Boolean permisoSeccionHistorialPreciosPiezaReportePdf) {
        this.permisoSeccionHistorialPreciosPiezaReportePdf = permisoSeccionHistorialPreciosPiezaReportePdf;
    }

    public Boolean getPermisoSeccionHistorialPreciosPiezaReporteExcel() {
        return permisoSeccionHistorialPreciosPiezaReporteExcel;
    }

    public void setPermisoSeccionHistorialPreciosPiezaReporteExcel(Boolean permisoSeccionHistorialPreciosPiezaReporteExcel) {
        this.permisoSeccionHistorialPreciosPiezaReporteExcel = permisoSeccionHistorialPreciosPiezaReporteExcel;
    }

    public Boolean getPermisoSeccionTipoPiezaAgregar() {
        return permisoSeccionTipoPiezaAgregar;
    }

    public void setPermisoSeccionTipoPiezaAgregar(Boolean permisoSeccionTipoPiezaAgregar) {
        this.permisoSeccionTipoPiezaAgregar = permisoSeccionTipoPiezaAgregar;
    }

    public Boolean getPermisoSeccionTipoPiezaModificar() {
        return permisoSeccionTipoPiezaModificar;
    }

    public void setPermisoSeccionTipoPiezaModificar(Boolean permisoSeccionTipoPiezaModificar) {
        this.permisoSeccionTipoPiezaModificar = permisoSeccionTipoPiezaModificar;
    }

    public Boolean getPermisoSeccionTipoPiezaDesactivar() {
        return permisoSeccionTipoPiezaDesactivar;
    }

    public void setPermisoSeccionTipoPiezaDesactivar(Boolean permisoSeccionTipoPiezaDesactivar) {
        this.permisoSeccionTipoPiezaDesactivar = permisoSeccionTipoPiezaDesactivar;
    }

    public Boolean getPermisoSeccionTipoPiezaReportePdf() {
        return permisoSeccionTipoPiezaReportePdf;
    }

    public void setPermisoSeccionTipoPiezaReportePdf(Boolean permisoSeccionTipoPiezaReportePdf) {
        this.permisoSeccionTipoPiezaReportePdf = permisoSeccionTipoPiezaReportePdf;
    }

    public Boolean getPermisoSeccionTipoPiezaReporteExcel() {
        return permisoSeccionTipoPiezaReporteExcel;
    }

    public void setPermisoSeccionTipoPiezaReporteExcel(Boolean permisoSeccionTipoPiezaReporteExcel) {
        this.permisoSeccionTipoPiezaReporteExcel = permisoSeccionTipoPiezaReporteExcel;
    }

    public Boolean getPermisoSeccionBuscarPiezaBuscar() {
        return permisoSeccionBuscarPiezaBuscar;
    }

    public void setPermisoSeccionBuscarPiezaBuscar(Boolean permisoSeccionBuscarPiezaBuscar) {
        this.permisoSeccionBuscarPiezaBuscar = permisoSeccionBuscarPiezaBuscar;
    }

    public Boolean getPermisoSeccionBuscarPiezaReportePdf() {
        return permisoSeccionBuscarPiezaReportePdf;
    }

    public void setPermisoSeccionBuscarPiezaReportePdf(Boolean permisoSeccionBuscarPiezaReportePdf) {
        this.permisoSeccionBuscarPiezaReportePdf = permisoSeccionBuscarPiezaReportePdf;
    }

    public Boolean getPermisoSeccionBuscarPiezaReporteExcel() {
        return permisoSeccionBuscarPiezaReporteExcel;
    }

    public void setPermisoSeccionBuscarPiezaReporteExcel(Boolean permisoSeccionBuscarPiezaReporteExcel) {
        this.permisoSeccionBuscarPiezaReporteExcel = permisoSeccionBuscarPiezaReporteExcel;
    }

    public Boolean getPermisoSeccionVehiculosAgregar() {
        return permisoSeccionVehiculosAgregar;
    }

    public void setPermisoSeccionVehiculosAgregar(Boolean permisoSeccionVehiculosAgregar) {
        this.permisoSeccionVehiculosAgregar = permisoSeccionVehiculosAgregar;
    }

    public Boolean getPermisoSeccionVehiculosModificar() {
        return permisoSeccionVehiculosModificar;
    }

    public void setPermisoSeccionVehiculosModificar(Boolean permisoSeccionVehiculosModificar) {
        this.permisoSeccionVehiculosModificar = permisoSeccionVehiculosModificar;
    }

    public Boolean getPermisoSeccionVehiculosDesactivar() {
        return permisoSeccionVehiculosDesactivar;
    }

    public void setPermisoSeccionVehiculosDesactivar(Boolean permisoSeccionVehiculosDesactivar) {
        this.permisoSeccionVehiculosDesactivar = permisoSeccionVehiculosDesactivar;
    }

    public Boolean getPermisoSeccionVehiculosReportePdf() {
        return permisoSeccionVehiculosReportePdf;
    }

    public void setPermisoSeccionVehiculosReportePdf(Boolean permisoSeccionVehiculosReportePdf) {
        this.permisoSeccionVehiculosReportePdf = permisoSeccionVehiculosReportePdf;
    }

    public Boolean getPermisoSeccionVehiculosReporteExcel() {
        return permisoSeccionVehiculosReporteExcel;
    }

    public void setPermisoSeccionVehiculosReporteExcel(Boolean permisoSeccionVehiculosReporteExcel) {
        this.permisoSeccionVehiculosReporteExcel = permisoSeccionVehiculosReporteExcel;
    }

    public Boolean getPermisoSeccionHistorialPreciosVehiculoBuscar() {
        return permisoSeccionHistorialPreciosVehiculoBuscar;
    }

    public void setPermisoSeccionHistorialPreciosVehiculoBuscar(Boolean permisoSeccionHistorialPreciosVehiculoBuscar) {
        this.permisoSeccionHistorialPreciosVehiculoBuscar = permisoSeccionHistorialPreciosVehiculoBuscar;
    }

    public Boolean getPermisoSeccionHistorialPreciosVehiculoReportePdf() {
        return permisoSeccionHistorialPreciosVehiculoReportePdf;
    }

    public void setPermisoSeccionHistorialPreciosVehiculoReportePdf(Boolean permisoSeccionHistorialPreciosVehiculoReportePdf) {
        this.permisoSeccionHistorialPreciosVehiculoReportePdf = permisoSeccionHistorialPreciosVehiculoReportePdf;
    }

    public Boolean getPermisoSeccionHistorialPreciosVehiculoReporteExcel() {
        return permisoSeccionHistorialPreciosVehiculoReporteExcel;
    }

    public void setPermisoSeccionHistorialPreciosVehiculoReporteExcel(Boolean permisoSeccionHistorialPreciosVehiculoReporteExcel) {
        this.permisoSeccionHistorialPreciosVehiculoReporteExcel = permisoSeccionHistorialPreciosVehiculoReporteExcel;
    }

    public Boolean getPermisoSeccionMarcaAgregar() {
        return permisoSeccionMarcaAgregar;
    }

    public void setPermisoSeccionMarcaAgregar(Boolean permisoSeccionMarcaAgregar) {
        this.permisoSeccionMarcaAgregar = permisoSeccionMarcaAgregar;
    }

    public Boolean getPermisoSeccionMarcaModificar() {
        return permisoSeccionMarcaModificar;
    }

    public void setPermisoSeccionMarcaModificar(Boolean permisoSeccionMarcaModificar) {
        this.permisoSeccionMarcaModificar = permisoSeccionMarcaModificar;
    }

    public Boolean getPermisoSeccionMarcaDesactivar() {
        return permisoSeccionMarcaDesactivar;
    }

    public void setPermisoSeccionMarcaDesactivar(Boolean permisoSeccionMarcaDesactivar) {
        this.permisoSeccionMarcaDesactivar = permisoSeccionMarcaDesactivar;
    }

    public Boolean getPermisoSeccionMarcaReportePdf() {
        return permisoSeccionMarcaReportePdf;
    }

    public void setPermisoSeccionMarcaReportePdf(Boolean permisoSeccionMarcaReportePdf) {
        this.permisoSeccionMarcaReportePdf = permisoSeccionMarcaReportePdf;
    }

    public Boolean getPermisoSeccionMarcaReporteExcel() {
        return permisoSeccionMarcaReporteExcel;
    }

    public void setPermisoSeccionMarcaReporteExcel(Boolean permisoSeccionMarcaReporteExcel) {
        this.permisoSeccionMarcaReporteExcel = permisoSeccionMarcaReporteExcel;
    }

    public Boolean getPermisoSeccionColorAgregar() {
        return permisoSeccionColorAgregar;
    }

    public void setPermisoSeccionColorAgregar(Boolean permisoSeccionColorAgregar) {
        this.permisoSeccionColorAgregar = permisoSeccionColorAgregar;
    }

    public Boolean getPermisoSeccionColorModificar() {
        return permisoSeccionColorModificar;
    }

    public void setPermisoSeccionColorModificar(Boolean permisoSeccionColorModificar) {
        this.permisoSeccionColorModificar = permisoSeccionColorModificar;
    }

    public Boolean getPermisoSeccionColorDesactivar() {
        return permisoSeccionColorDesactivar;
    }

    public void setPermisoSeccionColorDesactivar(Boolean permisoSeccionColorDesactivar) {
        this.permisoSeccionColorDesactivar = permisoSeccionColorDesactivar;
    }

    public Boolean getPermisoSeccionColorReportePdf() {
        return permisoSeccionColorReportePdf;
    }

    public void setPermisoSeccionColorReportePdf(Boolean permisoSeccionColorReportePdf) {
        this.permisoSeccionColorReportePdf = permisoSeccionColorReportePdf;
    }

    public Boolean getPermisoSeccionColorReporteExcel() {
        return permisoSeccionColorReporteExcel;
    }

    public void setPermisoSeccionColorReporteExcel(Boolean permisoSeccionColorReporteExcel) {
        this.permisoSeccionColorReporteExcel = permisoSeccionColorReporteExcel;
    }

    public Boolean getPermisoSeccionTipoVehiculoAgregar() {
        return permisoSeccionTipoVehiculoAgregar;
    }

    public void setPermisoSeccionTipoVehiculoAgregar(Boolean permisoSeccionTipoVehiculoAgregar) {
        this.permisoSeccionTipoVehiculoAgregar = permisoSeccionTipoVehiculoAgregar;
    }

    public Boolean getPermisoSeccionTipoVehiculoModificar() {
        return permisoSeccionTipoVehiculoModificar;
    }

    public void setPermisoSeccionTipoVehiculoModificar(Boolean permisoSeccionTipoVehiculoModificar) {
        this.permisoSeccionTipoVehiculoModificar = permisoSeccionTipoVehiculoModificar;
    }

    public Boolean getPermisoSeccionTipoVehiculoDesactivar() {
        return permisoSeccionTipoVehiculoDesactivar;
    }

    public void setPermisoSeccionTipoVehiculoDesactivar(Boolean permisoSeccionTipoVehiculoDesactivar) {
        this.permisoSeccionTipoVehiculoDesactivar = permisoSeccionTipoVehiculoDesactivar;
    }

    public Boolean getPermisoSeccionTipoVehiculoReportePdf() {
        return permisoSeccionTipoVehiculoReportePdf;
    }

    public void setPermisoSeccionTipoVehiculoReportePdf(Boolean permisoSeccionTipoVehiculoReportePdf) {
        this.permisoSeccionTipoVehiculoReportePdf = permisoSeccionTipoVehiculoReportePdf;
    }

    public Boolean getPermisoSeccionTipoVehiculoReporteExcel() {
        return permisoSeccionTipoVehiculoReporteExcel;
    }

    public void setPermisoSeccionTipoVehiculoReporteExcel(Boolean permisoSeccionTipoVehiculoReporteExcel) {
        this.permisoSeccionTipoVehiculoReporteExcel = permisoSeccionTipoVehiculoReporteExcel;
    }

    public Boolean getPermisoSeccionTipoCabinaAgregar() {
        return permisoSeccionTipoCabinaAgregar;
    }

    public void setPermisoSeccionTipoCabinaAgregar(Boolean permisoSeccionTipoCabinaAgregar) {
        this.permisoSeccionTipoCabinaAgregar = permisoSeccionTipoCabinaAgregar;
    }

    public Boolean getPermisoSeccionTipoCabinaModificar() {
        return permisoSeccionTipoCabinaModificar;
    }

    public void setPermisoSeccionTipoCabinaModificar(Boolean permisoSeccionTipoCabinaModificar) {
        this.permisoSeccionTipoCabinaModificar = permisoSeccionTipoCabinaModificar;
    }

    public Boolean getPermisoSeccionTipoCabinaDesactivar() {
        return permisoSeccionTipoCabinaDesactivar;
    }

    public void setPermisoSeccionTipoCabinaDesactivar(Boolean permisoSeccionTipoCabinaDesactivar) {
        this.permisoSeccionTipoCabinaDesactivar = permisoSeccionTipoCabinaDesactivar;
    }

    public Boolean getPermisoSeccionTipoCabinaReportePdf() {
        return permisoSeccionTipoCabinaReportePdf;
    }

    public void setPermisoSeccionTipoCabinaReportePdf(Boolean permisoSeccionTipoCabinaReportePdf) {
        this.permisoSeccionTipoCabinaReportePdf = permisoSeccionTipoCabinaReportePdf;
    }

    public Boolean getPermisoSeccionTipoCabinaReporteExcel() {
        return permisoSeccionTipoCabinaReporteExcel;
    }

    public void setPermisoSeccionTipoCabinaReporteExcel(Boolean permisoSeccionTipoCabinaReporteExcel) {
        this.permisoSeccionTipoCabinaReporteExcel = permisoSeccionTipoCabinaReporteExcel;
    }

    public Boolean getPermisoSeccionTipoCombustibleAgregar() {
        return permisoSeccionTipoCombustibleAgregar;
    }

    public void setPermisoSeccionTipoCombustibleAgregar(Boolean permisoSeccionTipoCombustibleAgregar) {
        this.permisoSeccionTipoCombustibleAgregar = permisoSeccionTipoCombustibleAgregar;
    }

    public Boolean getPermisoSeccionTipoCombustibleModificar() {
        return permisoSeccionTipoCombustibleModificar;
    }

    public void setPermisoSeccionTipoCombustibleModificar(Boolean permisoSeccionTipoCombustibleModificar) {
        this.permisoSeccionTipoCombustibleModificar = permisoSeccionTipoCombustibleModificar;
    }

    public Boolean getPermisoSeccionTipoCombustibleDesactivar() {
        return permisoSeccionTipoCombustibleDesactivar;
    }

    public void setPermisoSeccionTipoCombustibleDesactivar(Boolean permisoSeccionTipoCombustibleDesactivar) {
        this.permisoSeccionTipoCombustibleDesactivar = permisoSeccionTipoCombustibleDesactivar;
    }

    public Boolean getPermisoSeccionTipoCombustibleReportePdf() {
        return permisoSeccionTipoCombustibleReportePdf;
    }

    public void setPermisoSeccionTipoCombustibleReportePdf(Boolean permisoSeccionTipoCombustibleReportePdf) {
        this.permisoSeccionTipoCombustibleReportePdf = permisoSeccionTipoCombustibleReportePdf;
    }

    public Boolean getPermisoSeccionTipoCombustibleReporteExcel() {
        return permisoSeccionTipoCombustibleReporteExcel;
    }

    public void setPermisoSeccionTipoCombustibleReporteExcel(Boolean permisoSeccionTipoCombustibleReporteExcel) {
        this.permisoSeccionTipoCombustibleReporteExcel = permisoSeccionTipoCombustibleReporteExcel;
    }

    public Boolean getPermisoSeccionNumeroAsientosAgregar() {
        return permisoSeccionNumeroAsientosAgregar;
    }

    public void setPermisoSeccionNumeroAsientosAgregar(Boolean permisoSeccionNumeroAsientosAgregar) {
        this.permisoSeccionNumeroAsientosAgregar = permisoSeccionNumeroAsientosAgregar;
    }

    public Boolean getPermisoSeccionNumeroAsientosModificar() {
        return permisoSeccionNumeroAsientosModificar;
    }

    public void setPermisoSeccionNumeroAsientosModificar(Boolean permisoSeccionNumeroAsientosModificar) {
        this.permisoSeccionNumeroAsientosModificar = permisoSeccionNumeroAsientosModificar;
    }

    public Boolean getPermisoSeccionNumeroAsientosDesactivar() {
        return permisoSeccionNumeroAsientosDesactivar;
    }

    public void setPermisoSeccionNumeroAsientosDesactivar(Boolean permisoSeccionNumeroAsientosDesactivar) {
        this.permisoSeccionNumeroAsientosDesactivar = permisoSeccionNumeroAsientosDesactivar;
    }

    public Boolean getPermisoSeccionNumeroAsientosReportePdf() {
        return permisoSeccionNumeroAsientosReportePdf;
    }

    public void setPermisoSeccionNumeroAsientosReportePdf(Boolean permisoSeccionNumeroAsientosReportePdf) {
        this.permisoSeccionNumeroAsientosReportePdf = permisoSeccionNumeroAsientosReportePdf;
    }

    public Boolean getPermisoSeccionNumeroAsientosReporteExcel() {
        return permisoSeccionNumeroAsientosReporteExcel;
    }

    public void setPermisoSeccionNumeroAsientosReporteExcel(Boolean permisoSeccionNumeroAsientosReporteExcel) {
        this.permisoSeccionNumeroAsientosReporteExcel = permisoSeccionNumeroAsientosReporteExcel;
    }

    public Boolean getPermisoSeccionTipoTransmisionAgregar() {
        return permisoSeccionTipoTransmisionAgregar;
    }

    public void setPermisoSeccionTipoTransmisionAgregar(Boolean permisoSeccionTipoTransmisionAgregar) {
        this.permisoSeccionTipoTransmisionAgregar = permisoSeccionTipoTransmisionAgregar;
    }

    public Boolean getPermisoSeccionTipoTransmisionModificar() {
        return permisoSeccionTipoTransmisionModificar;
    }

    public void setPermisoSeccionTipoTransmisionModificar(Boolean permisoSeccionTipoTransmisionModificar) {
        this.permisoSeccionTipoTransmisionModificar = permisoSeccionTipoTransmisionModificar;
    }

    public Boolean getPermisoSeccionTipoTransmisionDesactivar() {
        return permisoSeccionTipoTransmisionDesactivar;
    }

    public void setPermisoSeccionTipoTransmisionDesactivar(Boolean permisoSeccionTipoTransmisionDesactivar) {
        this.permisoSeccionTipoTransmisionDesactivar = permisoSeccionTipoTransmisionDesactivar;
    }

    public Boolean getPermisoSeccionTipoTransmisionReportePdf() {
        return permisoSeccionTipoTransmisionReportePdf;
    }

    public void setPermisoSeccionTipoTransmisionReportePdf(Boolean permisoSeccionTipoTransmisionReportePdf) {
        this.permisoSeccionTipoTransmisionReportePdf = permisoSeccionTipoTransmisionReportePdf;
    }

    public Boolean getPermisoSeccionTipoTransmisionReporteExcel() {
        return permisoSeccionTipoTransmisionReporteExcel;
    }

    public void setPermisoSeccionTipoTransmisionReporteExcel(Boolean permisoSeccionTipoTransmisionReporteExcel) {
        this.permisoSeccionTipoTransmisionReporteExcel = permisoSeccionTipoTransmisionReporteExcel;
    }

    public Boolean getPermisoSeccionBuscarVehiculoBuscar() {
        return permisoSeccionBuscarVehiculoBuscar;
    }

    public void setPermisoSeccionBuscarVehiculoBuscar(Boolean permisoSeccionBuscarVehiculoBuscar) {
        this.permisoSeccionBuscarVehiculoBuscar = permisoSeccionBuscarVehiculoBuscar;
    }

    public Boolean getPermisoSeccionBuscarVehiculoReportePdf() {
        return permisoSeccionBuscarVehiculoReportePdf;
    }

    public void setPermisoSeccionBuscarVehiculoReportePdf(Boolean permisoSeccionBuscarVehiculoReportePdf) {
        this.permisoSeccionBuscarVehiculoReportePdf = permisoSeccionBuscarVehiculoReportePdf;
    }

    public Boolean getPermisoSeccionBuscarVehiculoExcel() {
        return permisoSeccionBuscarVehiculoExcel;
    }

    public void setPermisoSeccionBuscarVehiculoExcel(Boolean permisoSeccionBuscarVehiculoExcel) {
        this.permisoSeccionBuscarVehiculoExcel = permisoSeccionBuscarVehiculoExcel;
    }

    public Boolean getPermisoSeccionReporteReportePdfTabla() {
        return permisoSeccionReporteReportePdfTabla;
    }

    public void setPermisoSeccionReporteReportePdfTabla(Boolean permisoSeccionReporteReportePdfTabla) {
        this.permisoSeccionReporteReportePdfTabla = permisoSeccionReporteReportePdfTabla;
    }

    public Boolean getPermisoSeccionReporteBuscar() {
        return permisoSeccionReporteBuscar;
    }

    public void setPermisoSeccionReporteBuscar(Boolean permisoSeccionReporteBuscar) {
        this.permisoSeccionReporteBuscar = permisoSeccionReporteBuscar;
    }

    public Boolean getPermisoSeccionVentasAgregarPieza() {
        return permisoSeccionVentasAgregarPieza;
    }

    public void setPermisoSeccionVentasAgregarPieza(Boolean permisoSeccionVentasAgregarPieza) {
        this.permisoSeccionVentasAgregarPieza = permisoSeccionVentasAgregarPieza;
    }

    public Boolean getPermisoSeccionVentasAgregarVehiculo() {
        return permisoSeccionVentasAgregarVehiculo;
    }

    public void setPermisoSeccionVentasAgregarVehiculo(Boolean permisoSeccionVentasAgregarVehiculo) {
        this.permisoSeccionVentasAgregarVehiculo = permisoSeccionVentasAgregarVehiculo;
    }

    public Boolean getPermisoSeccionVentasBuscarPieza() {
        return permisoSeccionVentasBuscarPieza;
    }

    public void setPermisoSeccionVentasBuscarPieza(Boolean permisoSeccionVentasBuscarPieza) {
        this.permisoSeccionVentasBuscarPieza = permisoSeccionVentasBuscarPieza;
    }

    public Boolean getPermisoSeccionVentasBuscarVehiculo() {
        return permisoSeccionVentasBuscarVehiculo;
    }

    public void setPermisoSeccionVentasBuscarVehiculo(Boolean permisoSeccionVentasBuscarVehiculo) {
        this.permisoSeccionVentasBuscarVehiculo = permisoSeccionVentasBuscarVehiculo;
    }

    public Boolean getPermisoSeccionVentasGenerarVenta() {
        return permisoSeccionVentasGenerarVenta;
    }

    public void setPermisoSeccionVentasGenerarVenta(Boolean permisoSeccionVentasGenerarVenta) {
        this.permisoSeccionVentasGenerarVenta = permisoSeccionVentasGenerarVenta;
    }

    public Boolean getPermisoSeccionTipoFacturaAgregar() {
        return permisoSeccionTipoFacturaAgregar;
    }

    public void setPermisoSeccionTipoFacturaAgregar(Boolean permisoSeccionTipoFacturaAgregar) {
        this.permisoSeccionTipoFacturaAgregar = permisoSeccionTipoFacturaAgregar;
    }

    public Boolean getPermisoSeccionTipoFacturaModificar() {
        return permisoSeccionTipoFacturaModificar;
    }

    public void setPermisoSeccionTipoFacturaModificar(Boolean permisoSeccionTipoFacturaModificar) {
        this.permisoSeccionTipoFacturaModificar = permisoSeccionTipoFacturaModificar;
    }

    public Boolean getPermisoSeccionTipoFacturaDesactivar() {
        return permisoSeccionTipoFacturaDesactivar;
    }

    public void setPermisoSeccionTipoFacturaDesactivar(Boolean permisoSeccionTipoFacturaDesactivar) {
        this.permisoSeccionTipoFacturaDesactivar = permisoSeccionTipoFacturaDesactivar;
    }

    public Boolean getPermisoSeccionTipoFacturaReportePdf() {
        return permisoSeccionTipoFacturaReportePdf;
    }

    public void setPermisoSeccionTipoFacturaReportePdf(Boolean permisoSeccionTipoFacturaReportePdf) {
        this.permisoSeccionTipoFacturaReportePdf = permisoSeccionTipoFacturaReportePdf;
    }

    public Boolean getPermisoSeccionTipoFacturaReporteExcel() {
        return permisoSeccionTipoFacturaReporteExcel;
    }

    public void setPermisoSeccionTipoFacturaReporteExcel(Boolean permisoSeccionTipoFacturaReporteExcel) {
        this.permisoSeccionTipoFacturaReporteExcel = permisoSeccionTipoFacturaReporteExcel;
    }

    public Boolean getPermisoSeccionCaiAgregar() {
        return permisoSeccionCaiAgregar;
    }

    public void setPermisoSeccionCaiAgregar(Boolean permisoSeccionCaiAgregar) {
        this.permisoSeccionCaiAgregar = permisoSeccionCaiAgregar;
    }

    public Boolean getPermisoSeccionCaiModificar() {
        return permisoSeccionCaiModificar;
    }

    public void setPermisoSeccionCaiModificar(Boolean permisoSeccionCaiModificar) {
        this.permisoSeccionCaiModificar = permisoSeccionCaiModificar;
    }

    public Boolean getPermisoSeccionCaiDesactivar() {
        return permisoSeccionCaiDesactivar;
    }

    public void setPermisoSeccionCaiDesactivar(Boolean permisoSeccionCaiDesactivar) {
        this.permisoSeccionCaiDesactivar = permisoSeccionCaiDesactivar;
    }

    public Boolean getPermisoSeccionCaiReportePdf() {
        return permisoSeccionCaiReportePdf;
    }

    public void setPermisoSeccionCaiReportePdf(Boolean permisoSeccionCaiReportePdf) {
        this.permisoSeccionCaiReportePdf = permisoSeccionCaiReportePdf;
    }

    public Boolean getPermisoSeccionCaiReporteExcel() {
        return permisoSeccionCaiReporteExcel;
    }

    public void setPermisoSeccionCaiReporteExcel(Boolean permisoSeccionCaiReporteExcel) {
        this.permisoSeccionCaiReporteExcel = permisoSeccionCaiReporteExcel;
    }

    public Boolean getPermisoSeccionTipoPagoAgregar() {
        return permisoSeccionTipoPagoAgregar;
    }

    public void setPermisoSeccionTipoPagoAgregar(Boolean permisoSeccionTipoPagoAgregar) {
        this.permisoSeccionTipoPagoAgregar = permisoSeccionTipoPagoAgregar;
    }

    public Boolean getPermisoSeccionTipoPagoModificar() {
        return permisoSeccionTipoPagoModificar;
    }

    public void setPermisoSeccionTipoPagoModificar(Boolean permisoSeccionTipoPagoModificar) {
        this.permisoSeccionTipoPagoModificar = permisoSeccionTipoPagoModificar;
    }

    public Boolean getPermisoSeccionTipoPagoDesactivar() {
        return permisoSeccionTipoPagoDesactivar;
    }

    public void setPermisoSeccionTipoPagoDesactivar(Boolean permisoSeccionTipoPagoDesactivar) {
        this.permisoSeccionTipoPagoDesactivar = permisoSeccionTipoPagoDesactivar;
    }

    public Boolean getPermisoSeccionTipoPagoReportePdf() {
        return permisoSeccionTipoPagoReportePdf;
    }

    public void setPermisoSeccionTipoPagoReportePdf(Boolean permisoSeccionTipoPagoReportePdf) {
        this.permisoSeccionTipoPagoReportePdf = permisoSeccionTipoPagoReportePdf;
    }

    public Boolean getPermisoSeccionTipoPagoReporteExcel() {
        return permisoSeccionTipoPagoReporteExcel;
    }

    public void setPermisoSeccionTipoPagoReporteExcel(Boolean permisoSeccionTipoPagoReporteExcel) {
        this.permisoSeccionTipoPagoReporteExcel = permisoSeccionTipoPagoReporteExcel;
    }

    public Boolean getPermisoSeccionFacturasRechazadasBuscar() {
        return permisoSeccionFacturasRechazadasBuscar;
    }

    public void setPermisoSeccionFacturasRechazadasBuscar(Boolean permisoSeccionFacturasRechazadasBuscar) {
        this.permisoSeccionFacturasRechazadasBuscar = permisoSeccionFacturasRechazadasBuscar;
    }

    public Boolean getPermisoSeccionFacturasRechazadasRechazar() {
        return permisoSeccionFacturasRechazadasRechazar;
    }

    public void setPermisoSeccionFacturasRechazadasRechazar(Boolean permisoSeccionFacturasRechazadasRechazar) {
        this.permisoSeccionFacturasRechazadasRechazar = permisoSeccionFacturasRechazadasRechazar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacceso != null ? idacceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acceso)) {
            return false;
        }
        Acceso other = (Acceso) object;
        if ((this.idacceso == null && other.idacceso != null) || (this.idacceso != null && !this.idacceso.equals(other.idacceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Acceso[ idacceso=" + idacceso + " ]";
    }
    
}
