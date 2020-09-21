##########################################################################################
#
#   ArrayFire v3.7.0
#
##########################################################################################

SECTION = "libs"
LICENSE = "BSD"
SUMMARY = "Accelerated computing library"
DESCRIPTION = "The ArrayFire accelerated computing library is a free, general-purpose, open-source library that simplifies the process of developing software that targets parallel and massively-parallel architectures including CPUs, GPUs, and other hardware acceleration devices"
HOMEPAGE = "https://arrayfire.com/"

LIC_FILES_CHKSUM = " \
    file://LICENSES/Apache-2.0.txt;md5=b86da86f51f932e74ac18c8bf2a19eb5 \
    file://LICENSES/Boost%20Software%20License.txt;md5=2c7a3fa82e66676005cd4ee2608fd7d2 \
    file://LICENSES/BSD%203-Clause.txt;md5=d1fc1c1014953f267fe73266a6b0e253 \
    file://LICENSES/FreeImage%20Public%20License.txt;md5=ffcd65468a2d2b3e3e43fbaf63ceedf7 \
    file://LICENSES/ISSL%20License.txt;md5=1ba0d78ed416760e4a8ef3dc121e69c8 \
    file://LICENSES/Half(MIT)%20License.txt;md5=146884358d3553418ec92e4808a30718 \
    file://LICENSES/OpenSIFT%20License.txt;md5=7a69fc0ac94076df51f7db9b0c02fe7c \
    file://LICENSES/zlib-libpng%20License.txt;md5=09b00738058950409d6955872d715416"


SRC_URI = "gitsm://github.com/arrayfire/arrayfire.git;protocol=https;branch=v3.7"
SRCREV = "218dd2c99300e77496239ade76e94b0def65d032"

FILESEXTRAPATHS_prepend := "${THISDIR}/arrayfire_3.7.2:"

SRC_URI += " \
    file://0001-fix-main-cmakelists-txt-for-yocto-build.patch \
    file://0002-replace-space-characters-with-semicolon-in-CUDA_NVCC.patch \
"

PR="r0"

S = "${WORKDIR}/git"
