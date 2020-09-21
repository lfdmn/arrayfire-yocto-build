LICENSE = "CLOSED"

do_fetch[noexec] = "1"
do_configure[noexec] = "1"
do_compile[noexec] = "1"

# Add missing symlinks required by arrayfire
do_install(){
    install -d ${D}/usr/local/cuda-10.0/lib/

    ln -sf libcublas.so.10.0 ${D}/usr/local/cuda-10.0/lib/libcublas.so
    ln -sf libcudart.so.10.0 ${D}/usr/local/cuda-10.0/lib/libcudart.so
    ln -sf libcufft.so.10.0 ${D}/usr/local/cuda-10.0/lib/libcufft.so
    ln -sf libcufftw.so.10.0 ${D}/usr/local/cuda-10.0/lib/libcufftw.so
    ln -sf libcuinj64.so.10.0 ${D}/usr/local/cuda-10.0/lib/libcuinj64.so
    ln -sf libcurand.so.10.0 ${D}/usr/local/cuda-10.0/lib/libcurand.so
    ln -sf libcusolver.so.10.0 ${D}/usr/local/cuda-10.0/lib/libcusolver.so
    ln -sf libcusparse.so.10.0 ${D}/usr/local/cuda-10.0/lib/libcusparse.so
    ln -sf libnppc.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnppc.so
    ln -sf libnppial.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnppial.so
    ln -sf libnppicc.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnppicc.so
    ln -sf libnppicom.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnppicom.so
    ln -sf libnppidei.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnppidei.so
    ln -sf libnppif.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnppif.so
    ln -sf libnppig.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnppig.so
    ln -sf libnppim.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnppim.so
    ln -sf libnppist.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnppist.so
    ln -sf libnppisu.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnppisu.so
    ln -sf libnppitc.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnppitc.so
    ln -sf libnpps.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnpps.so
    ln -sf libnvblas.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnvblas.so
    ln -sf libnvrtc-builtins.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnvrtc-builtins.so
    ln -sf libnvrtc.so.10.0 ${D}/usr/local/cuda-10.0/lib/libnvrtc.so
}

FILES_${PN} = "/usr/local/cuda-10.0/lib/*"
INSANE_SKIP_${PN} = "dev-so libdir"
